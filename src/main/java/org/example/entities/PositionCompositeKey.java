package org.example.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PositionCompositeKey implements Serializable {
    private Dish dish;
    private Order order;

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
    @JsonManagedReference
    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonManagedReference
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionCompositeKey that = (PositionCompositeKey) o;
        return Objects.equals(dish, that.dish) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dish, order);
    }
}