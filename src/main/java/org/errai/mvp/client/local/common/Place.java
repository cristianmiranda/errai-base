package org.errai.mvp.client.local.common;

import org.errai.mvp.client.local.about.AboutPresenter;
import org.errai.mvp.client.local.common.mvp.places.IsPlace;
import org.errai.mvp.client.local.index.IndexPresenter;
import org.errai.mvp.client.local.navigation.NavigationPresenter;
import org.errai.mvp.client.shared.common.mvp.Presenter;

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
