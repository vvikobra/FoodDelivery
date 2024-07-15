package org.example.services.Impl;

import org.example.repositories.Impl.UserRepositoryImpl;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Override
    public String findDeliveryAreaById(Integer id) {
        return userRepository.findDeliveryAreaById(id);
    }
}
