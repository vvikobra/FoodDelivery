package org.example.contollers;

import org.example.entities.Dish;
import org.example.services.Impl.DishServiceImpl;
import org.example.services.Impl.DomainDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {

    @Autowired
    private DishServiceImpl dishService;

    @GetMapping("dish/menu")
    String menu(@RequestParam double weight, @RequestParam double height) {
        return dishService.generateDailyMenu(weight, height);
    }

}
