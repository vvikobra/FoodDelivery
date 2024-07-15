package org.example.entities.enums;

public enum CourierStatus {
    FREE(0),
    BUSY(1);

    private final int index;

    CourierStatus(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
