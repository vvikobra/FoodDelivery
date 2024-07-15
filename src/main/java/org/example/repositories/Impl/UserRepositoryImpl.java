package org.example.repositories.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entities.User;
import org.example.repositories.BaseRepository;
import org.example.repositories.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepository<User, Integer> implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public String findDeliveryAreaById(Integer id) {
        return entityManager.createQuery("select deliveryArea from User u where u.id = :id")
                .setParameter("id", id).toString();
    }
}
