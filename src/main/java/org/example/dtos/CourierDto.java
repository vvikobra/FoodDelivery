package org.example.dtos;

import org.example.entities.enums.CourierTransportType;

public class CourierDto {

    private int id;
    private String deliveryArea;
    private String name;
    private String phoneNumber;
    private String status;
    private CourierTransportType transportType;

    public CourierDto(int id, String deliveryArea, String name, String phoneNumber, String status, CourierTransportType transportType) {
        this.id = id;
        this.deliveryArea = deliveryArea;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.transportType = transportType;
    }

    public CourierDto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CourierTransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(CourierTransportType transportType) {
        this.transportType = transportType;
    }
}
