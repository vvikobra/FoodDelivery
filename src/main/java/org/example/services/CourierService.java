package org.example.services;

import org.example.entities.Courier;

import java.util.List;

public interface CourierService {

    List<Courier> findByDeliveryAreaAndStatus(String deliveryArea);
}
