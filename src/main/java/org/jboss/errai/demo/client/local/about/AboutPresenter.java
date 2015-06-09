package org.jboss.errai.demo.client.local.about;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.demo.client.local.common.Places;
import org.jboss.errai.demo.client.local.common.mvp.HasUiHandler;
import org.jboss.errai.demo.client.local.common.mvp.Presenter;
import org.jboss.errai.demo.client.local.common.mvp.places.IsPlace;
import org.jboss.errai.demo.client.local.common.mvp.places.PlaceRequest;
import org.jboss.errai.demo.client.shared.about.services.PrintService;

@Dependent
public class AboutPresenter extends Presenter<AboutPresenter.MyView> implements AboutUiHandler {
    public interface MyView extends HasUiHandler {
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
                PlaceRequest placeRequest = new PlaceRequest.Builder().to(Places.INDEX)
                        .with("Response", response).build();
                getPlaceManager().reveal(placeRequest);
            }
        }).print();
    }

    @Override
    protected IsPlace getPlace() {
        return Places.ABOUT;
    }

    private void print(String response) {
        getView().show("About + " + response);
        getView().alert("About2 + " + response);
    }
}
