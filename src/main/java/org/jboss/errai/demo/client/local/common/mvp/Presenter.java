package org.jboss.errai.demo.client.local.common.mvp;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.demo.client.local.common.mvp.places.IsPlace;
import org.jboss.errai.demo.client.local.common.mvp.places.PlaceCallbackHandler;
import org.jboss.errai.demo.client.local.common.mvp.places.PlaceManager;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 13:51
 */
public abstract class Presenter<T extends HasUiHandler> extends PlaceCallbackHandler {

    @Inject
    private PlaceManager placeManager;
    @Inject
    private T view;

    @PostConstruct
    public void postConstruct() {
    }

    public T getView() {
        return view;
    }

    public PlaceManager getPlaceManager() {
        return placeManager;
    }

    protected abstract IsPlace getPlace();
}
