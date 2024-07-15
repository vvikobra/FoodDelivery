package org.example.services;

import org.example.entities.Dish;

import java.util.List;

public interface DishService {
    List<Dish> findByTypeAndCalories(String type, double minCalories, double maxCalories);
}
