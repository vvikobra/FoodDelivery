package org.example.repositories;

public interface OrderRepository {

    void updateCourierIdByUserIdAndOrderId(Integer orderId, Integer courierId);
}
