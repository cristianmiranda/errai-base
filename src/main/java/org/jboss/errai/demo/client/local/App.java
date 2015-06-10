package org.jboss.errai.demo.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.demo.client.local.index.IndexPresenter;
import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * This is the entry point to the client portion of the web application. At
 * compile time, Errai finds the {@code @EntryPoint} annotation on this class
 * and generates bootstrap code that creates an instance of this class when the
 * page loads. This client-side bootstrap code will also call the
 * {@link #init()} method because it is annotated with the
 * {@code @PostConstruct} annotation.
 */
@EntryPoint
@Page(role = DefaultPage.class)
public class App extends Composite {

    @Inject
    IndexPresenter indexPresenter;

    @PostConstruct
    private void init() {
        // This is specifying the relative path to the REST endpoint used to store
        // complaints on the server. When compiling the native mobile app of this
        // demo, this needs to be changed to an absolute URL.
        RestClient.setApplicationRoot("rest");
        // RestClient.setApplicationRoot("http://10.15.16.207:8080/errai-tutorial/rest");
        RootPanel.get("rootPanel").clear();
        RootPanel.get("rootPanel").add(indexPresenter);
        indexPresenter.onReveal(null);
    }
}
