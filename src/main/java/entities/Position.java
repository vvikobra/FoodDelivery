package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Position {
    private PositionCompositeKey compositeKey;
    private int dishesQuantity;

    public Position(PositionCompositeKey compositeKey, int dishesQuantity) {
        this.compositeKey = compositeKey;
        this.dishesQuantity = dishesQuantity;
    }

    protected Position() {
    }

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
