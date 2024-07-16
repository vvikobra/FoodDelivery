package org.example.contollers;

import org.example.services.Impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dish")
public class DishController {

    @Autowired
    private DishServiceImpl dishService;

    @GetMapping("/menu")
    String menu(@RequestParam double weight, @RequestParam double height) {
        return dishService.generateDailyMenu(weight, height);
    }

}
