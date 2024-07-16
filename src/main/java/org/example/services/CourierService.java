package org.example.services;

import org.example.dtos.CourierDto;

import java.util.List;

public interface CourierService {

    List<CourierDto> findByDeliveryAreaAndStatus(String deliveryArea);
}
