package org.example.services.Impl;

import org.example.entities.Dish;
import org.example.entities.enums.DishType;
import org.example.repositories.Impl.DishRepositoryImpl;
import org.example.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepositoryImpl dishRepository;

    public String generateDailyMenu(double weight, double height) {
        double baseCalorieContent = (10 * weight + 6.25 * height - 5 * 30 + 5) * 1.55;

        int mealCalories = (int) (baseCalorieContent / 4);

        int snackCalories = mealCalories / 2;

        List<Dish> breakfastDishes = findByTypeAndCalories(DishType.BREAKFAST, mealCalories - 50, mealCalories + 50);
        List<Dish> lunchDishes = findByTypeAndCalories(DishType.LUNCH, mealCalories - 50, mealCalories + 50);
        List<Dish> dinnerDishes = findByTypeAndCalories(DishType.DINNER, mealCalories - 50, mealCalories + 50);
        List<Dish> snackDishes = findByTypeAndCalories(DishType.SNACK, snackCalories - 25, snackCalories + 25);

        return "Ваше меню на день:\n" +
                "Завтрак: " + selectDish(breakfastDishes) + "\n" +
                "Перекус 1: " + selectDish(snackDishes) + "\n" +
                "Обед: " + selectDish(lunchDishes) + "\n" +
                "Перекус 2: " + selectDish(snackDishes) + "\n" +
                "Ужин: " + selectDish(dinnerDishes) + "\n";
    }

    private String selectDish(List<Dish> dishes) {
        if (dishes.isEmpty()) {
            return "Нет подходящих блюд";
        }
        int randomIndex = (int) (Math.random() * dishes.size());
        return dishes.get(randomIndex).getName() + " - " + dishes.get(randomIndex).getCalories() + " калорий";
    }

    @Override
    public List<Dish> findByTypeAndCalories(DishType type, int minCalories, int maxCalories) {
        return dishRepository.findByTypeAndCalories(type, minCalories, maxCalories);
    }
}
