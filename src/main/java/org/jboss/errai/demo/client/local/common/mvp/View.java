package org.jboss.errai.demo.client.local.common.mvp;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.gwt.user.client.ui.Composite;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 13:51
 */
public class View<T extends UiHandler> extends Composite {

    private static final Logger logger = Logger.getLogger(View.class.getSimpleName());

    @Inject
    private T presenter;

    public T getUiHandlers() {
        return presenter;
    }
}
