package org.example.repositories;

import org.example.entities.Dish;
import org.example.entities.Position;

import java.util.List;

public interface PositionRepository {

    List<Dish> findDishesByUserId(Integer userId);

    List<Position> findByOrderId(Integer orderId);
}