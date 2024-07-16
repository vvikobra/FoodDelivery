package org.example.services;

import org.example.dtos.DishDto;
import org.example.entities.enums.DishType;

import java.util.List;

public interface DishService {
    List<DishDto> findByTypeAndCalories(DishType type, int minCalories, int maxCalories);
}
