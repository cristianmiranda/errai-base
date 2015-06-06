package org.jboss.errai.demo.client.local.common.mvp;

import javax.inject.Inject;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 13:51
 */
public class Presenter<T extends HasUiHandler> {

    @Inject
    private T view;

    public T getView() {
        return view;
    }

    /**
     * Only for test purposes
     * @param view
     */
    public void setView(T view) {
        this.view = view;
    }
}
