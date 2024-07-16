package org.example.services.Impl;

import org.example.dtos.CourierDto;
import org.example.entities.Dish;
import org.example.entities.Position;
import org.example.entities.enums.CourierTransportType;
import org.example.exception.NoSuitableCourierException;
import org.example.repositories.Impl.CourierRepositoryImpl;
import org.example.repositories.Impl.OrderRepositoryImpl;
import org.example.repositories.Impl.PositionRepositoryImpl;
import org.example.repositories.Impl.UserRepositoryImpl;
import org.example.services.CourierService;
import org.example.services.OrderService;
import org.example.services.PositionService;
import org.example.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainCourierService implements PositionService, CourierService, UserService, OrderService {

    @Autowired
    private PositionRepositoryImpl positionRepository;

    @Autowired
    private CourierRepositoryImpl courierRepository;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private OrderRepositoryImpl orderRepository;

    private final ModelMapper modelMapper = new ModelMapper();

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

    public CourierDto findSuitableCourier(Integer orderId, Integer userId) {
        try {
            String deliveryArea = findDeliveryAreaById(userId);
            List<CourierDto> availableCouriers = findByDeliveryAreaAndStatus(deliveryArea);
            int orderWeight = calculateOrderWeight(orderId) / 1000;
            CourierDto suitableCourier = null;
            for (CourierDto courier : availableCouriers) {
                if (orderWeight <= 5 && CourierTransportType.WALKING.equals(courier.getTransportType())) {
                    suitableCourier = courier;
                } else if (orderWeight > 5 && orderWeight <= 10 && CourierTransportType.BICYCLE.equals(courier.getTransportType())) {
                    suitableCourier = courier;
                } else if (orderWeight > 10 && CourierTransportType.CAR.equals(courier.getTransportType())) {
                    suitableCourier = courier;
                }
            }
            if (suitableCourier == null) {
                throw new NoSuitableCourierException(orderId);
            }
            updateCourierIdByUserIdAndOrderId(orderId, suitableCourier.getId());
            return suitableCourier;
        } catch (Exception e) {
            System.err.println("Error finding suitable courier: " + e.getMessage());
            throw e;
        }
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
    public List<CourierDto> findByDeliveryAreaAndStatus(String deliveryArea) {
        return courierRepository.findByDeliveryAreaAndStatus(deliveryArea).stream().map((s) -> modelMapper.map(s, CourierDto.class)).toList();
    }

    @Override
    public String findDeliveryAreaById(Integer id) {
        return userRepository.findDeliveryAreaById(id);
    }

    @Override
    public void updateCourierIdByUserIdAndOrderId(Integer orderId, Integer courierId) {
        orderRepository.updateCourierIdByUserIdAndOrderId(orderId, courierId);
    }
}
