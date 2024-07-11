package entities;

import jakarta.persistence.*;

@Embeddable
public class PositionCompositeKey {
    private Dish dish;
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
