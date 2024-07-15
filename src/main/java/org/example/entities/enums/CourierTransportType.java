package org.example.entities.enums;

public enum CourierTransportType {
    WALKING(0),
    BICYCLE(1),
    CAR(2);

    private final int index;

    CourierTransportType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}