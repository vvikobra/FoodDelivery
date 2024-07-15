package org.example.repositories.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.Courier;
import org.example.repositories.BaseRepository;
import org.example.repositories.CourierRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourierRepositoryImpl extends BaseRepository<Courier, Integer> implements CourierRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CourierRepositoryImpl() {
        super(Courier.class);
    }

//    @Override
//    @Transactional
//    public Courier updateCourierSetStatusForId(String status, Integer id) {
//        entityManager.createQuery("update Courier c set c.status = :status where c.id = :id")
//                .setParameter("status", status)
//                .setParameter("id", id)
//                .executeUpdate();
//        return entityManager.find(Courier.class, id);
//    }


    @Override
    public List<Courier> findByDeliveryAreaAndStatus(String deliveryArea) {
        return entityManager.createQuery("from Courier c where c.deliveryArea = :deliveryArea and c.status = 'FREE'", Courier.class)
                .setParameter("deliveryArea", deliveryArea)
                .getResultList();
    }
}
