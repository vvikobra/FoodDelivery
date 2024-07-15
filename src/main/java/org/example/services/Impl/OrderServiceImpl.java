package org.example.services.Impl;

import org.example.entities.Order;
import org.example.repositories.Impl.OrderRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepositoryImpl orderRepository;

    @Override
    public Order updateOrderStatusForId(String status, int id) {
        return orderRepository.updateOrderSetStatusForId(status, id);
    }

}