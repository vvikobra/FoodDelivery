package org.example.dtos;

import org.example.entities.enums.DishType;

public class DishDto {
    private String name;
    private String description;
    private int cost;
    private int calories;
    private int weight;
    private DishType type;

    public DishDto(String name, String description, int cost, int calories, int weight, DishType type) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.calories = calories;
        this.weight = weight;
        this.type = type;
    }

    public DishDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }
}
