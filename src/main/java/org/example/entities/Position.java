package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class Position {
    private PositionCompositeKey compositeKey;
    private int dishesQuantity;

    @EmbeddedId
    @Column(nullable = false)
    public PositionCompositeKey getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(PositionCompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    @Column(name = "dishes_quantity", nullable = false)
    public int getDishesQuantity() {
        return dishesQuantity;
    }

    public void setDishesQuantity(int dishesQuantity) {
        this.dishesQuantity = dishesQuantity;
    }
}
