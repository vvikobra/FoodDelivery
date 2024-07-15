package org.example.repositories;

import org.example.entities.Order;

public interface OrderRepository {

    Order updateOrderSetStatusForId(String status, Integer id);
}