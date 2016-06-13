package org.errai.mvp.client.local.about;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.errai.mvp.client.local.common.Place;
import org.errai.mvp.client.local.common.mvp.IsView;
import org.errai.mvp.client.local.common.mvp.places.IsPlace;
import org.errai.mvp.client.local.common.mvp.places.PlaceRequest;
import org.errai.mvp.client.local.common.mvp.slots.RevealType;
import org.errai.mvp.client.local.common.mvp.slots.SlotHolder;
import org.errai.mvp.client.local.index.IndexPresenter;
import org.errai.mvp.client.shared.about.services.PrintService;
import org.errai.mvp.client.shared.common.mvp.Presenter;
import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;

@ApplicationScoped
public class AboutPresenter extends Presenter<AboutPresenter.MyView> implements AboutUiHandler {
    public interface MyView extends IsView {
        void show(String response);
        void alert(String response);
    }

    private final Caller<PrintService> printService;

    @Inject
    public AboutPresenter(
            Caller<PrintService> printService) {
        this.printService = printService;
    }

    @Override
    public void onReveal(Message message) {
        print("woooha");
    }

    @Override
    public void print() {
        printService.call(new RemoteCallback<String>() {
            @Override
            public void callback(String response) {
                PlaceRequest placeRequest = new PlaceRequest.Builder().to(Place.INDEX)
                        .with("Response", response).build();
                getPlaceManager().reveal(placeRequest);
            }
        }).print();
    }

    @Override
    public IsPlace getPlace() {
        return Place.ABOUT;
    }

    @Override
    protected RevealType getRevealType() {
        return RevealType.CONTENT;
    }

    @Override
    protected SlotHolder revealOnSlot() {
        return new SlotHolder(Place.INDEX, IndexPresenter.SLOT_CONTENT);
    }

    private void print(String response) {
        getView().show("About + " + response);
        getView().alert("About2 + " + response);
    }
}
