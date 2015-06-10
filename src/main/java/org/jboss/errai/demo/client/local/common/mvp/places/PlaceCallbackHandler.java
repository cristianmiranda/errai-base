package org.jboss.errai.demo.client.local.common.mvp.places;

import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.bus.client.api.messaging.MessageCallback;

/**
 * @author Cristian Miranda
 * @since 6/8/15 - 10:11
 */
public abstract class PlaceCallbackHandler implements MessageCallback {

    protected abstract void reveal();

    public abstract void onReveal(Message message);

    @Override
    public void callback(Message message) {
        reveal();
        onReveal(message);
    }
}
