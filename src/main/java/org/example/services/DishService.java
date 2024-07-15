package org.example.services;

import org.example.entities.Dish;
import org.example.entities.enums.DishType;

import java.util.List;

public interface DishService {
    List<Dish> findByTypeAndCalories(DishType type, int minCalories, int maxCalories);
}
