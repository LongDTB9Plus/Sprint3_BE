package com.parking.models.DAO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private String license;
    private String color;
    private String producer;
    @OneToMany(mappedBy = "car", cascade = CascadeType.MERGE)
    @JsonBackReference
    private Set<Parking> parkings;

    public Set<Parking> getParkings() {
        return parkings;
    }

    public void setParkings(Set<Parking> parkings) {
        this.parkings = parkings;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

}
