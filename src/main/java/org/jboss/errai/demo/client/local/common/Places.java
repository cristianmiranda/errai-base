package org.jboss.errai.demo.client.local.common;

import org.jboss.errai.demo.client.local.about.AboutPresenter;
import org.jboss.errai.demo.client.local.common.mvp.Presenter;
import org.jboss.errai.demo.client.local.common.mvp.places.IsPlace;
import org.jboss.errai.demo.client.local.index.IndexPresenter;

/**
 * @author Cristian Miranda
 * @since 6/8/15 - 10:26
 */
public enum Places implements IsPlace {
    INDEX(IndexPresenter.class),
    ABOUT(AboutPresenter.class);

    Class<? extends Presenter> presenterClass;

    Places(Class<? extends Presenter> presenterClass) {
        this.presenterClass = presenterClass;
    }

    public Class<? extends Presenter> getPresenter(){
        return presenterClass;
    }
}
