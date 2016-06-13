package org.errai.mvp.client.local.common.mvp;

import org.errai.mvp.client.local.common.mvp.slots.Slot;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 14:42
 */
public interface IsView {
    void addToSlot(Slot slot, IsWidget content);
    void removeFromSlot(Slot slot, IsWidget content);
    void setInSlot(Slot slot, IsWidget content);
    Widget asWidget();
}
