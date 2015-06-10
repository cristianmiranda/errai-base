package org.jboss.errai.demo.client.local.index;

import org.jboss.errai.demo.client.local.common.mvp.View;
import org.jboss.errai.demo.client.local.common.mvp.slots.Slot;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;

import static org.jboss.errai.demo.client.local.index.IndexPresenter.MyView;
import static org.jboss.errai.demo.client.local.index.IndexPresenter.SLOT_CONTENT;
import static org.jboss.errai.demo.client.local.index.IndexPresenter.SLOT_MENU_BAR;

@Page
@Templated("IndexView.html#root")
public class IndexView extends View<IndexUiHandler> implements MyView {

    @DataField
    HTMLPanel mainContainer = new HTMLPanel("");
    @DataField
    HTMLPanel navigationContainer = new HTMLPanel("");

    @Override
    public void setInSlot(Slot slot, IsWidget content) {
        if (slot == SLOT_CONTENT) {
            mainContainer.clear();
            mainContainer.add(content);
        } else if (slot == SLOT_MENU_BAR) {
            navigationContainer.clear();
            navigationContainer.add(content);
        } else {
            super.setInSlot(slot, content);
        }
    }
}
