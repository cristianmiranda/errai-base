package org.jboss.errai.demo.client.local.common;

import org.jboss.errai.demo.client.local.about.AboutPresenter;
import org.jboss.errai.demo.client.local.common.mvp.places.IsPlace;
import org.jboss.errai.demo.client.local.index.IndexPresenter;
import org.jboss.errai.demo.client.local.navigation.NavigationPresenter;
import org.jboss.errai.demo.client.shared.common.mvp.Presenter;

/**
 * @author Cristian Miranda
 * @since 6/8/15 - 10:26
 */
public enum Place implements IsPlace {
    INDEX(IndexPresenter.class),
    NAVIGATION(NavigationPresenter.class),
    ABOUT(AboutPresenter.class);

    Class<? extends Presenter> presenterClass;

    Place(Class<? extends Presenter> presenterClass) {
        this.presenterClass = presenterClass;
    }

    public Class<? extends Presenter> getPresenter() {
        return presenterClass;
    }
}
