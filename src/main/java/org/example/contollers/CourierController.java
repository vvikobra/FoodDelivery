package org.example.contollers;

import org.example.dtos.CourierDto;
import org.example.services.Impl.DomainCourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courier")
public class CourierController {

    @Autowired
    private DomainCourierService courierService;

    @GetMapping("/search/{orderId}/{userId}")
    public CourierDto search(@PathVariable() Integer orderId, @PathVariable() Integer userId) {
        return courierService.findSuitableCourier(orderId, userId);
    }
}