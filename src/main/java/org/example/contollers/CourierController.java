package org.example.contollers;

import org.example.entities.Courier;
import org.example.services.Impl.DomainCourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourierController {

    @Autowired
    private DomainCourierService courierService;

    @GetMapping("courier/search")
    Courier search(@RequestParam Integer orderId, @RequestParam Integer userId) {
        System.out.println("orderId: " + orderId + ", userId: " + userId);
        return courierService.findSuitableCourier(orderId, userId);
    }
}