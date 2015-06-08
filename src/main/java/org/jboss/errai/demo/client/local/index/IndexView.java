package org.jboss.errai.demo.client.local.index;

import org.jboss.errai.demo.client.local.common.mvp.View;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Page(path = "Index")
@Templated("IndexView.html#root")
public class IndexView extends View<IndexUiHandler> implements IndexPresenter.MyView {

}
