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
    private EntityManager entityManager;

    public OrderRepositoryImpl() {
        super(Order.class);
    }

    @Override
    @Transactional
    public Order updateOrderSetStatusForId(String status, Integer id) {
        entityManager.createQuery("update Order o set o.status = :status where o.id = :id")
                .setParameter("status", status)
                .setParameter("id", id)
                .executeUpdate();
        return entityManager.find(Order.class, id);
    }
}
