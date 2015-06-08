package org.jboss.errai.demo.client.local.common.mvp;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.demo.client.local.common.mvp.places.IsPlace;
import org.jboss.errai.demo.client.local.common.mvp.places.PlaceCallbackHandler;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 13:51
 */
public abstract class Presenter<T extends HasUiHandler> extends PlaceCallbackHandler {

    @Inject
    private T view;

    @PostConstruct
    public void postConstruct() {
    }

    public T getView() {
        return view;
    }

    /**
     * Only for test purposes
     *
     * @param view
     */
    public void setView(T view) {
        this.view = view;
    }

    protected abstract IsPlace getPlace();
}
