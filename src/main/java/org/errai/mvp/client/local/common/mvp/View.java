package org.errai.mvp.client.local.common.mvp;

import javax.inject.Inject;

import org.errai.mvp.client.local.common.mvp.slots.Slot;
import org.errai.mvp.client.shared.common.mvp.UiHandler;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 13:51
 */
public abstract class View<T extends UiHandler> extends Composite {

    @Inject
    private T presenter;

    public T getUiHandlers() {
        return presenter;
    }

    public void addToSlot(Slot slot, IsWidget content) {
    }

    public void removeFromSlot(Slot slot, IsWidget content) {
    }

    public void setInSlot(Slot slot, IsWidget content) {
    }
}
