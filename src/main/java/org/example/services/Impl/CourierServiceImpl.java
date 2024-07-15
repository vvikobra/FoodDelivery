package org.example.services.Impl;

import org.example.entities.Courier;
import org.example.repositories.Impl.CourierRepositoryImpl;
import org.example.services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierRepositoryImpl courierRepository;

    @Override
    public List<Courier> findByDeliveryAreaAndStatus(String deliveryArea) {
        return courierRepository.findByDeliveryAreaAndStatus(deliveryArea);
    }
}