package org.jboss.errai.demo.client.local.navigation;

import javax.inject.Inject;

import org.jboss.errai.demo.client.local.common.mvp.View;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Anchor;

@Page
@Templated("NavigationView.html#root")
public class NavigationView extends View<NavigationUiHandler> implements NavigationPresenter.MyView {

    @Inject
    @DataField
    Anchor about;
    @Inject
    @DataField
    Anchor services;
    @Inject
    @DataField
    Anchor contact;

    @EventHandler("about")
    public void onAbout(ClickEvent clickEvent) {
        getUiHandlers().about();
    }

    @EventHandler("services")
    public void onServices(ClickEvent clickEvent) {
        getUiHandlers().services();
    }

    @EventHandler("contact")
    public void onContact(ClickEvent clickEvent) {
        getUiHandlers().contact();
    }
}
