package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "courier")
public class Courier extends BaseEntity {
    private String name;
    private String phoneNumber;
    private String deliveryArea;
    private String vehicle;
    private Set<Order> orders;

    public Courier(String name, String phoneNumber, String deliveryArea, String vehicle, Set<Order> orders) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.deliveryArea = deliveryArea;
        this.vehicle = vehicle;
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
    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @OneToMany(mappedBy = "order", targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}