package entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Dish extends BaseEntity {
    private String name;
    private String description;
    private int cost;
    private int calories;
    private int protein;
    private int fats;
    private int carbs;
    private int weight;
    private Set<Position> positions;

    public Dish(String name, String description, int cost, int calories, int protein, int fats, int carbs, int weight, Set<Position> positions) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.calories = calories;
        this.protein = protein;
        this.fats = fats;
        this.carbs = carbs;
        this.weight = weight;
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
    public double getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Column(nullable = false)
    public double getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Column(nullable = false)
    public double getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    @Column(nullable = false)
    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    @Column(nullable = false)
    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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
