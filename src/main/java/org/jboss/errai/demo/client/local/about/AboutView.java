package org.jboss.errai.demo.client.local.about;

import javax.inject.Inject;

import org.jboss.errai.demo.client.local.common.mvp.View;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;

/**
 * This is the companion Java class of the complaint form as specified by
 * {@link Templated}. It refers to a data field called "app-template" in
 * ComplaintForm.html as its root and gains access to all data fields in the
 * template to add dynamic behavior (e.g. event handlers, data bindings, page
 * transitions).
 * <p/>
 * The {@link Page} annotation declares this form as a bookmarkable page that
 * can be transitioned to by other pages of this application. Further the
 * specified role (DefaultPage.class) make this page appear by default when the
 * application is started.
 */
@Page
@Templated("AboutView.html#root")
public class AboutView extends View<AboutUiHandler> implements AboutPresenter.MyView {
    @Inject
    @DataField
    private Button submit;

    @EventHandler("submit")
    public void onSubmit(ClickEvent clickEvent) {
        getUiHandlers().print();
    }

    @Override
    public void show(String response) {
        System.out.println(response);
    }

    @Override
    public void alert(String response) {
        Window.alert(response);
    }
}
