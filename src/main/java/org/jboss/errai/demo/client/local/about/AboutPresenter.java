package org.jboss.errai.demo.client.local.about;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.demo.client.local.common.Place;
import org.jboss.errai.demo.client.local.common.mvp.IsView;
import org.jboss.errai.demo.client.local.common.mvp.Presenter;
import org.jboss.errai.demo.client.local.common.mvp.places.IsPlace;
import org.jboss.errai.demo.client.local.common.mvp.places.PlaceRequest;
import org.jboss.errai.demo.client.local.common.mvp.slots.RevealType;
import org.jboss.errai.demo.client.local.common.mvp.slots.SlotHolder;
import org.jboss.errai.demo.client.local.index.IndexPresenter;
import org.jboss.errai.demo.client.shared.about.services.PrintService;

@Dependent
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
    protected IsPlace getPlace() {
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
