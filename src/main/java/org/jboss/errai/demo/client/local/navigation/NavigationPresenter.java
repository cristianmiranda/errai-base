package org.jboss.errai.demo.client.local.navigation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.demo.client.local.common.Place;
import org.jboss.errai.demo.client.local.common.mvp.IsView;
import org.jboss.errai.demo.client.local.common.mvp.places.IsPlace;
import org.jboss.errai.demo.client.local.common.mvp.places.PlaceRequest;
import org.jboss.errai.demo.client.local.common.mvp.slots.RevealType;
import org.jboss.errai.demo.client.local.common.mvp.slots.SlotHolder;
import org.jboss.errai.demo.client.local.index.IndexPresenter;
import org.jboss.errai.demo.client.shared.common.mvp.Presenter;

@ApplicationScoped
public class NavigationPresenter extends Presenter<NavigationPresenter.MyView> implements NavigationUiHandler {
    public interface MyView extends IsView {
    }

    @Inject
    public NavigationPresenter() {
    }

    @Override
    public void onReveal(Message message) {
    }

    @Override
    public void about() {
        getPlaceManager().reveal(new PlaceRequest.Builder().to(Place.ABOUT).build());
    }

    @Override
    public void services() {
    }

    @Override
    public void contact() {
    }

    @Override
    public IsPlace getPlace() {
        return Place.NAVIGATION;
    }

    @Override
    protected RevealType getRevealType() {
        return RevealType.CONTENT;
    }

    @Override
    protected SlotHolder revealOnSlot() {
        return new SlotHolder(Place.INDEX, IndexPresenter.SLOT_MENU_BAR);
    }
}
