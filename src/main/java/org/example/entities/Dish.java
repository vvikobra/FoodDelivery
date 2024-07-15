package org.example.entities;


import jakarta.persistence.*;
import org.example.entities.enums.DishType;

import java.util.Set;

@Entity
@Table (name = "dish")
public class Dish extends BaseEntity {
    private String name;
    private String description;
    private int cost;
    private int calories;
    private int weight;
    private DishType type;
    private Set<Position> positions;

    public Dish(String name, String description, int cost, int calories, int weight, DishType type, Set<Position> positions) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.calories = calories;
        this.weight = weight;
        this.type = type;
        this.positions = positions;
    }

    protected Dish() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Column(nullable = false)
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Column(nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public DishType getType() {
        return type;
    }
    public void setType(DishType type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "compositeKey.dish", targetEntity = Position.class)
    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
