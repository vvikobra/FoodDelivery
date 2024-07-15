package org.example.entities;

import org.example.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private OffsetDateTime registrationDate;
    private OrderStatus status;
    private User user;
    private Courier courier;
    private Set<Position> positions;

    public Order(OffsetDateTime registrationDate, User user, Courier courier, Set<Position> positions) {
        this.registrationDate = registrationDate;
        this.status = OrderStatus.CREATED;
        this.user = user;
        this.courier = courier;
        this.positions = positions;
    }

    protected Order() {
    }

    @Column(name = "registration_date", nullable = false)
    public OffsetDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(OffsetDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id", nullable = false)
    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    @OneToMany(mappedBy = "compositeKey.order", targetEntity = Position.class)
    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
