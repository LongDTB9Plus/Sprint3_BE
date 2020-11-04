package com.parking.models.DAO;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParking;
    private LocalDateTime dateIn;
    private LocalDateTime dateOut;
    private Boolean status;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "car_id")
    @JsonManagedReference
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getIdParking() {
        return idParking;
    }

    public void setIdParking(Integer idParking) {
        this.idParking = idParking;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDateTime dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDateTime dateOut) {
        this.dateOut = dateOut;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
