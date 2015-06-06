package org.jboss.errai.demo.client.local.about;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.demo.client.local.about.AboutPresenter.MyView;
import org.jboss.errai.demo.client.local.common.mvp.HasUiHandler;
import org.jboss.errai.demo.client.local.common.mvp.Presenter;
import org.jboss.errai.demo.client.shared.index.services.PrintService;

@ApplicationScoped
public class AboutPresenter extends Presenter<MyView> implements AboutUiHandler {
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
    public void print() {
        printService.call(new RemoteCallback<String>() {
            @Override
            public void callback(String response) {
                getView().show("About + " + response);
                getView().alert("About + " + response);
            }
        }).print();
    }
}
