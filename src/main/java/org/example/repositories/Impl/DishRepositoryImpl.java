package org.example.repositories.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Dish;
import org.example.entities.enums.DishType;
import org.example.repositories.BaseRepository;
import org.example.repositories.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishRepositoryImpl extends BaseRepository<Dish, Integer> implements DishRepository {

    public DishRepositoryImpl() {
        super(Dish.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Dish> findByTypeAndCalories(DishType type, Integer minCalories, Integer maxCalories) {
        return entityManager.createQuery("from Dish d where d.type = :type and d.calories between :minCalories and :maxCalories", Dish.class)
                .setParameter("type", type)
                .setParameter("minCalories", minCalories)
                .setParameter("maxCalories", maxCalories)
                .getResultList();
    }
}
