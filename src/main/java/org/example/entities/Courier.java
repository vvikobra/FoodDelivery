package org.example.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.example.entities.enums.CourierStatus;
import org.example.entities.enums.CourierTransportType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "courier")
public class Courier extends BaseEntity {
    private String name;
    private String phoneNumber;
    private String deliveryArea;
    private CourierTransportType transportType;
    private CourierStatus status;
    private Set<Order> orders;

    public Courier(String name, String phoneNumber, String deliveryArea, CourierTransportType transportType, Set<Order> orders) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.deliveryArea = deliveryArea;
        this.transportType = transportType;
        this.status = CourierStatus.FREE;
        this.orders = orders;
    }

    protected Courier() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "delivery_area", nullable = false)
    public String getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public CourierTransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(CourierTransportType transportType) {
        this.transportType = transportType;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public CourierStatus getStatus() {
        return status;
    }

    public void setStatus(CourierStatus status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "courier",targetEntity = Order.class)
    @JsonBackReference
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}