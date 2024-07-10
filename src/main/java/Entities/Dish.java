package Entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Dish extends BaseEntity {
    private String name;
    private String description;
    private int cost;
    private double calories;
    private double protein;
    private double fats;
    private double carbs;
    private double weight;
    private Set<Position> positions;

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

    @Column(nullable = false, scale = 1)
    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Column(nullable = false, scale = 1)
    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    @Column(nullable = false, scale = 1)
    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    @Column(nullable = false, scale = 1)
    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    @Column(nullable = false, scale = 1)
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @OneToMany(mappedBy = "position", targetEntity = Position.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
