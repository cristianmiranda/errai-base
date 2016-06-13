package org.errai.mvp.client.local.common.mvp.places;

import org.errai.mvp.client.shared.common.mvp.Presenter;

/**
 * @author Cristian Miranda
 * @since 6/8/15 - 10:26
 */
public interface IsPlace {
    Class<? extends Presenter> getPresenter();
}
