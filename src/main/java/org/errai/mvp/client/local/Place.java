package org.errai.mvp.client.local;

import org.errai.mvp.client.local.mvp.places.IsPlace;
import org.errai.mvp.client.shared.mvp.Presenter;

/**
 * @author Cristian Miranda
 * @since 6/8/15 - 10:26
 */
public enum Place implements IsPlace {
    DO_NOT_USE(null);

    Class<? extends Presenter> presenterClass;

    Place(Class<? extends Presenter> presenterClass) {
        this.presenterClass = presenterClass;
    }

    public Class<? extends Presenter> getPresenter() {
        return presenterClass;
    }
}
