package org.example.services;

import org.example.entities.Order;

public interface OrderService {
    Order updateOrderStatusForId(String status, int id);

}
