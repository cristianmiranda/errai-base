package org.jboss.errai.demo.client.local.index;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.demo.client.local.common.Places;
import org.jboss.errai.demo.client.local.common.mvp.HasUiHandler;
import org.jboss.errai.demo.client.local.common.mvp.Presenter;
import org.jboss.errai.demo.client.local.common.mvp.places.IsPlace;
import org.jboss.errai.demo.client.local.common.mvp.places.PlaceManager;

import com.google.gwt.user.client.Window;

@Dependent
public class IndexPresenter extends Presenter<IndexPresenter.MyView> implements IndexUiHandler {
    public interface MyView extends HasUiHandler {
    }

    private final PlaceManager placeManager;

    @Inject
    public IndexPresenter(
            PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    @Override
    public void onReveal(Message message) {
        Window.alert("INDEX");
    }

    @Override
    protected IsPlace getPlace() {
        return Places.INDEX;
    }
}
