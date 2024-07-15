package org.example.repositories;

import org.example.entities.Dish;
import org.example.entities.Position;

import java.util.List;

public interface PositionRepository {

    //Поиск блюд, заказанных пользователем, для формирования рекомендаций
    List<Dish> findDishesByUserId(Integer userId);

    //Поиск позиций заказа для расчёта веса заказа
    List<Position> findByOrderId(Integer orderId);
}