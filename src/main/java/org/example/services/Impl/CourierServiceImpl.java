package org.example.services.Impl;

import org.example.dtos.CourierDto;
import org.example.repositories.Impl.CourierRepositoryImpl;
import org.example.services.CourierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierRepositoryImpl courierRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CourierDto> findByDeliveryAreaAndStatus(String deliveryArea) {
        return courierRepository.findByDeliveryAreaAndStatus(deliveryArea).stream().map((s) -> modelMapper.map(s, CourierDto.class)).toList();
    }
}