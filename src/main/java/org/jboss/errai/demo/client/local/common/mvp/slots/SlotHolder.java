package org.jboss.errai.demo.client.local.common.mvp.slots;

import org.jboss.errai.demo.client.local.common.Place;

/**
 * @author Cristian Miranda
 * @since 6/9/15 - 23:42
 */
public class SlotHolder {
    private final Place host;
    private final Slot slot;

    public SlotHolder(Place host, Slot slot) {
        this.host = host;
        this.slot = slot;
    }

    public Place getHost() {
        return host;
    }

    public Slot getSlot() {
        return slot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SlotHolder that = (SlotHolder) o;

        if (host != that.host) {
            return false;
        }
        return !(slot != null ? !slot.equals(that.slot) : that.slot != null);
    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + (slot != null ? slot.hashCode() : 0);
        return result;
    }
}
