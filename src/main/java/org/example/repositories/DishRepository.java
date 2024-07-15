package org.example.repositories;

import org.example.entities.Dish;
import org.example.entities.enums.DishType;

import java.util.List;

public interface DishRepository {

    //Поиск блюд для формирования рекомендаций
    List<Dish> findByTypeAndCalories(DishType type, Integer minCalories, Integer maxCalories);

}
