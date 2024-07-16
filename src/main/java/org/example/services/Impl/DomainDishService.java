package org.example.services.Impl;

import org.example.dtos.DishDto;
import org.example.entities.Dish;
import org.example.entities.Position;
import org.example.entities.enums.DishType;
import org.example.repositories.Impl.DishRepositoryImpl;
import org.example.repositories.Impl.PositionRepositoryImpl;
import org.example.services.DishService;
import org.example.services.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomainDishService implements PositionService, DishService {

    @Autowired
    private PositionRepositoryImpl positionRepository;

    @Autowired
    private DishRepositoryImpl dishRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<DishDto> getRecommendedDishes(Integer userId) {
        List<Dish> userDishes = findDishesByUserId(userId);
        List<DishDto> recommendedDishes = new ArrayList<>();
        int calories;
        int minCalories;
        int maxCalories;
        DishType type;

        for (Dish userDish : userDishes) {
            type = userDish.getType();
            calories = userDish.getCalories();
            minCalories = (int) (calories * 0.9);
            maxCalories = (int) (calories * 1.1);

            recommendedDishes.addAll(findByTypeAndCalories(type, minCalories, maxCalories));
        }

        return recommendedDishes;
    }

    @Override
    public List<DishDto> findByTypeAndCalories(DishType type, int minCalories, int maxCalories) {
        return dishRepository.findByTypeAndCalories(type, minCalories, maxCalories).stream().map((s) -> modelMapper.map(s, DishDto.class)).toList();
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
