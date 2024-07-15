package org.example.services.Impl;

import org.example.entities.Courier;
import org.example.entities.Dish;
import org.example.entities.Position;
import org.example.entities.enums.CourierTransportType;
import org.example.repositories.Impl.CourierRepositoryImpl;
import org.example.repositories.Impl.DishRepositoryImpl;
import org.example.repositories.Impl.PositionRepositoryImpl;
import org.example.repositories.Impl.UserRepositoryImpl;
import org.example.services.CourierService;
import org.example.services.DishService;
import org.example.services.PositionService;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomainService implements DishService, PositionService, CourierService, UserService {

    @Autowired
    private PositionRepositoryImpl positionRepository;

    @Autowired
    private CourierRepositoryImpl courierRepository;

    @Autowired
    private DishRepositoryImpl dishRepository;

    @Autowired
    private UserRepositoryImpl userRepository;

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

            recommendedDishes = findByTypeAndCalories(type, minCalories, maxCalories);
        }

        return recommendedDishes;
    }

    public int calculateOrderWeight(Integer orderId) {
        List<Position> positions = findByOrderId(orderId);
        int totalWeight = 0;
        int quantity;
        int dishWeight;

        for (Position position : positions) {
            Dish dish = position.getCompositeKey().getDish();
            quantity = position.getDishesQuantity();
            dishWeight = dish.getWeight();
            totalWeight += dishWeight * quantity;
        }

        return totalWeight;
    }

    public Courier findSuitableCourier(String deliveryArea, double orderWeight, Integer orderId, Integer userId) {
        List<Courier> availableCouriers = findByDeliveryAreaAndStatus(deliveryArea);
        orderWeight = calculateOrderWeight(orderId);
        deliveryArea = findDeliveryAreaById(userId);
        for (Courier courier : availableCouriers) {
            if (orderWeight <= 5 && CourierTransportType.WALKING.equals(courier.getTransportType())) {
                return courier;
            } else if (orderWeight > 5 && orderWeight <= 10 && CourierTransportType.BICYCLE.equals(courier.getTransportType())) {
                return courier;
            } else if (orderWeight > 10 && CourierTransportType.CAR.equals(courier.getTransportType())) {
                return courier;
            }
        }
        return null;
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

    @Override
    public List<Courier> findByDeliveryAreaAndStatus(String deliveryArea) {
        return courierRepository.findByDeliveryAreaAndStatus(deliveryArea);
    }

    @Override
    public Courier updateCourierSetStatusForId(String status, Integer id) {
        return courierRepository.updateCourierSetStatusForId(status, id);
    }

    @Override
    public String findDeliveryAreaById(Integer id) {
        return userRepository.findDeliveryAreaById(id);
    }
}
