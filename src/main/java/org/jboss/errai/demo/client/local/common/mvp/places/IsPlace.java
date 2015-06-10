package org.jboss.errai.demo.client.local.common.mvp.places;

import org.jboss.errai.demo.client.local.common.mvp.Presenter;

/**
 * @author Cristian Miranda
 * @since 6/8/15 - 10:26
 */
public interface IsPlace {
    Class<? extends Presenter> getPresenter();
}
