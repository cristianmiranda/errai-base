package org.errai.mvp.client.shared.common.mvp;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.errai.mvp.client.local.common.mvp.IsView;
import org.errai.mvp.client.local.common.mvp.places.IsPlace;
import org.errai.mvp.client.local.common.mvp.places.PlaceCallbackHandler;
import org.errai.mvp.client.local.common.mvp.places.PlaceManager;
import org.errai.mvp.client.local.common.mvp.slots.RevealType;
import org.errai.mvp.client.local.common.mvp.slots.Slot;
import org.errai.mvp.client.local.common.mvp.slots.SlotHolder;
import org.errai.mvp.client.local.common.mvp.slots.SlotHolderEvent;
import org.jboss.errai.bus.client.api.messaging.Message;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 13:51
 */
public abstract class Presenter<T extends IsView> extends PlaceCallbackHandler implements IsWidget {

    @Inject
    private PlaceManager placeManager;
    @Inject
    private T view;
    private RevealType revealType;
    private Slot revealOnSlot;

    @Inject
    private Event<SlotHolderEvent> slotHolderEvent;

    public T getView() {
        return view;
    }

    @Override
    protected void reveal() {
        RevealType revealType = getRevealType();
        switch (revealType) {
            case ROOT:
                revealInRoot();
                break;
            case CONTENT:
                revealOnHolder();
                break;
            case POPUP:
                break;
            default:
                break;
        }
    }

    @Override
    public void onReveal(Message message) {
    }

    public PlaceManager getPlaceManager() {
        return placeManager;
    }

    public void addToSlot(Slot slot, IsWidget content) {
        getView().addToSlot(slot, content);
    }

    public void removeFromSlot(Slot slot, IsWidget content) {
        getView().removeFromSlot(slot, content);
    }

    public void setInSlot(Slot slot, IsWidget content) {
        getView().setInSlot(slot, content);
    }

    @Override
    public Widget asWidget() {
        return getView().asWidget();
    }

    public void onSlotHolderEvent(@Observes SlotHolderEvent slotHolderEvent) {
        if (slotHolderEvent != null) {
            SlotHolder slotHolder = slotHolderEvent.getSlotHolder();
            if (slotHolder != null && slotHolder.getHost() != null && getPlace().equals(slotHolder.getHost())) {
                setInSlot(slotHolder.getSlot(), slotHolderEvent.getContent());
            }
        }
    }

    public abstract IsPlace getPlace();

    protected abstract RevealType getRevealType();

    protected abstract SlotHolder revealOnSlot();

    private void revealInRoot() {
        RootPanel.get().clear();
        RootPanel.get().add(this);
    }

    private void revealOnHolder() {
        SlotHolder slotHolder = revealOnSlot();
        slotHolderEvent.fire(new SlotHolderEvent(slotHolder, this));
    }
}
