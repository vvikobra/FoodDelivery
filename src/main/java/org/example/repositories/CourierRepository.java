package org.example.repositories;

import org.example.entities.Courier;

import java.util.List;

public interface CourierRepository {

    Courier updateCourierSetStatusForId(String status, Integer id);

    //Поиск курьеров с данным районом доставки для поиска подходящего курьера
    List<Courier> findByDeliveryAreaAndStatus(String deliveryArea);
}
