package org.example.services.Impl;

import org.example.entities.Dish;
import org.example.entities.Position;
import org.example.repositories.Impl.DishRepositoryImpl;
import org.example.repositories.Impl.PositionRepositoryImpl;
import org.example.services.DishService;
import org.example.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DomainDishService implements PositionService, DishService {

    @Autowired
    private PositionRepositoryImpl positionRepository;

    @Autowired
    private DishRepositoryImpl dishRepository;

    public List<Dish> getRecommendedDishes(Integer userId) {
        List<Dish> userDishes = findDishesByUserId(userId);
        List<Dish> recommendedDishes = new ArrayList<>();
        int calories;
        double minCalories;
        double maxCalories;
        String type;

        for (Dish userDish : userDishes) {
            type = userDish.getType().toString();
            calories = userDish.getCalories();
            minCalories = calories * 0.9;
            maxCalories = calories * 1.1;

            recommendedDishes.addAll(findByTypeAndCalories(type, minCalories, maxCalories));
        }

        return recommendedDishes;
    }

    @Override
    public List<Dish> findByTypeAndCalories(String type, double minCalories, double maxCalories) {
        return dishRepository.findByTypeAndCalories(type, minCalories, maxCalories);
    }

    @Override
    public List<Dish> findDishesByUserId(Integer userId) {
        return positionRepository.findDishesByUserId(userId);
    }

    @Override
    public List<Position> findByOrderId(Integer orderId) {
        return positionRepository.findByOrderId(orderId);
    }
}
