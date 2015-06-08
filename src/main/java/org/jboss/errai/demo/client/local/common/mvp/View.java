package org.jboss.errai.demo.client.local.common.mvp;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.Composite;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 13:51
 */
public abstract class View<T extends UiHandler> extends Composite {

    @Inject
    private T presenter;

    @PostConstruct
    public void postConstruct() {
        onBind();
    }

    public T getUiHandlers() {
        return presenter;
    }

    public void onBind() {
        // Will optionally override
    }
}
