package org.example.services.Impl;

import org.example.entities.Dish;
import org.example.entities.Position;
import org.example.repositories.Impl.PositionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.services.PositionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepositoryImpl positionRepository;

    @Override
    public List<Dish> findDishesByUserId(Integer userId) {
        return positionRepository.findDishesByUserId(userId);
    }

    @Override
    public List<Position> findByOrderId(Integer orderId) {
        return positionRepository.findByOrderId(orderId);
    }
}