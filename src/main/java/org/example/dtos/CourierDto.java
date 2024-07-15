package org.example.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourierDto {

    private String deliveryArea;
    private String name;
    private String phoneNumber;
    private String status;
    private String transportType;
}
