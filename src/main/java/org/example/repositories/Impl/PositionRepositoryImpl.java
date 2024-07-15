package org.example.repositories.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entities.Dish;
import org.example.entities.Position;
import org.example.entities.PositionCompositeKey;
import org.example.repositories.BaseRepository;
import org.example.repositories.PositionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionRepositoryImpl extends BaseRepository<Position, PositionCompositeKey> implements PositionRepository {

    @PersistenceContext
    public EntityManager entityManager;

    public PositionRepositoryImpl() {
        super(Position.class);
    }

    @Override
    @Transactional
    public List<Dish> findDishesByUserId(Integer userId) {
        return entityManager.createQuery("select p.compositeKey.dish from Position p where p.compositeKey.order.user.id = :userId", Dish.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Position> findByOrderId(Integer orderId) {
        return entityManager.createQuery("from Position p where p.compositeKey.order.id = :orderId", Position.class)
                .setParameter("orderId", orderId)
                .getResultList();
    }
}
