package org.example.contollers;

import org.example.entities.Dish;
import org.example.services.Impl.DomainDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendController {

    @Autowired
    private DomainDishService domainDishService;

    @GetMapping("dish/recommend")
    Iterable<Dish> recommend(@RequestParam Integer id) {
        return domainDishService.getRecommendedDishes(id);
    }
}
