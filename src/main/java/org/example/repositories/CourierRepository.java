package org.example.repositories;

import org.example.entities.Courier;

import java.util.List;

public interface CourierRepository {

    List<Courier> findByDeliveryAreaAndStatus(String deliveryArea);
}
