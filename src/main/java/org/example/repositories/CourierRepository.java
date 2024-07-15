package org.example.repositories;

import org.example.entities.Courier;

import java.util.List;

public interface CourierRepository {

    //Поиск курьеров с данным районом доставки для поиска подходящего курьера
    List<Courier> findByDeliveryAreaAndStatus(String deliveryArea);
}
