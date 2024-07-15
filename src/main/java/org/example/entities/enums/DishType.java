package org.example.entities.enums;

public enum DishType {
    BREAKFAST(0),
    LUNCH(1),
    DINNER(2),
    SNACK(3);

    private final int index;

    DishType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
