package org.example.services;

import org.example.entities.Dish;
import org.example.entities.Position;

import java.util.List;

public interface PositionService {

    List<Dish> findDishesByUserId(Integer userId);

    List<Position> findByOrderId(Integer orderId);
}
