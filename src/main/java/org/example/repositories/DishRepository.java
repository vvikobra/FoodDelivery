package org.example.repositories;

import org.example.entities.Dish;

import java.util.List;

public interface DishRepository {

    //Поиск блюд для формирования рекомендаций
    List<Dish> findByTypeAndCalories(String type, Double minCalories, Double maxCalories);

}
