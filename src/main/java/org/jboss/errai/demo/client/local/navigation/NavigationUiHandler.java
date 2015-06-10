package org.jboss.errai.demo.client.local.navigation;

import org.jboss.errai.demo.client.local.common.mvp.UiHandler;

/**
 * @author Cristian Miranda
 * @since 6/6/15 - 14:40
 */
public interface NavigationUiHandler extends UiHandler {
    void about();
    void services();
    void contact();
}
