package org.errai.mvp.client.local.mvp.slots;

import org.errai.mvp.client.shared.mvp.Presenter;

/**
 * @author Cristian Miranda
 * @since 6/9/15 - 23:42
 */
public class SlotHolderEvent {
    private final SlotHolder slotHolder;
    private final Presenter content;

    public SlotHolderEvent(SlotHolder slotHolder, Presenter content) {
        this.slotHolder = slotHolder;
        this.content = content;
    }

    public SlotHolder getSlotHolder() {
        return slotHolder;
    }

    public Presenter getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SlotHolderEvent that = (SlotHolderEvent) o;

        if (slotHolder != null ? !slotHolder.equals(that.slotHolder) : that.slotHolder != null) {
            return false;
        }
        return !(content != null ? !content.equals(that.content) : that.content != null);
    }

    @Override
    public int hashCode() {
        int result = slotHolder != null ? slotHolder.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
