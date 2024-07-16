package org.example.contollers;

import org.example.dtos.DishDto;
import org.example.services.Impl.DomainDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dish")
public class RecommendController {

    @Autowired
    private DomainDishService domainDishService;

    @GetMapping("/recommend/{userId}")
    Iterable<DishDto> recommend(@PathVariable() Integer userId) {
        return domainDishService.getRecommendedDishes(userId);
    }
}
