package org.errai.mvp.client.local.index;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.errai.mvp.client.local.common.Place;
import org.errai.mvp.client.local.common.mvp.IsView;
import org.errai.mvp.client.local.common.mvp.places.EntryPlace;
import org.errai.mvp.client.local.common.mvp.places.IsPlace;
import org.errai.mvp.client.local.common.mvp.slots.RevealType;
import org.errai.mvp.client.local.common.mvp.slots.Slot;
import org.errai.mvp.client.local.common.mvp.slots.SlotHolder;
import org.errai.mvp.client.local.navigation.NavigationPresenter;
import org.errai.mvp.client.shared.common.mvp.Presenter;
import org.jboss.errai.bus.client.api.messaging.Message;

@EntryPlace
@ApplicationScoped
public class IndexPresenter extends Presenter<IndexPresenter.MyView> implements IndexUiHandler {
    public interface MyView extends IsView {
    }

    public static final Slot SLOT_MENU_BAR = new Slot();
    public static final Slot SLOT_CONTENT = new Slot();

    private final NavigationPresenter navigationPresenter;

    @Inject
    public IndexPresenter(
            NavigationPresenter navigationPresenter) {
        this.navigationPresenter = navigationPresenter;
    }

    @Override
    public void onReveal(Message message) {
        setInSlot(SLOT_MENU_BAR, navigationPresenter);
    }

    @Override
    public IsPlace getPlace() {
        return Place.INDEX;
    }

    @Override
    protected RevealType getRevealType() {
        return RevealType.ROOT;
    }

    @Override
    protected SlotHolder revealOnSlot() {
        return null;
    }
}
