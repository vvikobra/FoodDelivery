package org.example.repositories.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Order;
import org.example.repositories.BaseRepository;
import org.example.repositories.OrderRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderRepositoryImpl extends BaseRepository<Order, Integer> implements OrderRepository {

    @PersistenceContext
    public EntityManager entityManager;

    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    @Transactional
    public void updateCourierIdByUserIdAndOrderId(Integer orderId, Integer courierId) {
        entityManager.createQuery("update Order o set o.courier.id = :courierId where o.id = :orderId")
                .setParameter("orderId", orderId)
                .setParameter("courierId", courierId)
                .executeUpdate();
    }
}
