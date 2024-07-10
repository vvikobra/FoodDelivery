package Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Position {
    private PositionCompositeKey compositeKey;
    private int dishesQuantity;

    @Column(nullable = false)
    public PositionCompositeKey getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(PositionCompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    @Column(nullable = false)
    public int getDishesQuantity() {
        return dishesQuantity;
    }

    public void setDishesQuantity(int dishesQuantity) {
        this.dishesQuantity = dishesQuantity;
    }
}
