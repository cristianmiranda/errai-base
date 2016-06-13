package org.errai.mvp.client.local.common.mvp.places;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.errai.mvp.client.shared.common.mvp.Presenter;
import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.api.messaging.MessageBus;
import org.jboss.errai.ioc.client.container.IOCBeanDef;
import org.jboss.errai.ioc.client.container.SyncBeanManager;

import com.google.common.base.Preconditions;

/**
 * @author Cristian Miranda
 * @since 6/7/15 - 15:00
 */
@ApplicationScoped
public class PlaceManager {

    public static final String CHANNEL_NAME = "client-channel";

    private MessageBus bus;
    private Map<IsPlace, Presenter> registeredPlaces;
    private SyncBeanManager beanManager;

    public PlaceManager() {
        // Needed by CDI
    }

    @Inject
    public PlaceManager(
            SyncBeanManager beanManager) {
        this.bus = ErraiBus.get();
        this.registeredPlaces = new HashMap<IsPlace, Presenter>();
        this.beanManager = beanManager;
    }

    public void reveal(PlaceRequest placeRequest) {
        checkPreconditions(placeRequest);
        checkPlaceRegistration(placeRequest.getPlace());
        MessageBuilder
                .createMessage()
                .toSubject(CHANNEL_NAME + placeRequest.getPlace())
                .command((Enum) placeRequest.getPlace())
                .withValue(placeRequest.getParams())
                .defaultErrorHandling()
                .sendNowWith(bus);
    }

    private void checkPreconditions(PlaceRequest placeRequest) {
        Preconditions.checkNotNull(placeRequest, "PlaceRequest cannot be null");
        Preconditions.checkNotNull(placeRequest.getPlace(), "PlaceRequest's place cannot be null");
        Preconditions.checkArgument(placeRequest.getPlace() instanceof Enum, "PlaceRequest must be an Enum");
    }

    private void checkPlaceRegistration(IsPlace place) {
        if (!registeredPlaces.containsKey(place)) {
            IOCBeanDef<? extends Presenter> bean = beanManager.lookupBean(place.getPresenter());
            Presenter presenter = bean.getInstance();
            ErraiBus.get().subscribe(PlaceManager.CHANNEL_NAME + place, presenter);
            registeredPlaces.put(place, presenter);
        }
    }
}
