package org.example.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private OffsetDateTime registrationDate;
    private User user;
    private Courier courier;
    private Set<Position> positions;

    public Order(OffsetDateTime registrationDate, User user, Courier courier, Set<Position> positions) {
        this.registrationDate = registrationDate;
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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    @OneToMany(mappedBy = "compositeKey.order", targetEntity = Position.class)
    @JsonBackReference
    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
