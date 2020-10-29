package com.parking.models.DTO;

import java.util.Set;

public class CarDTO {
    private Integer carId;
    private String license;
    private String color;
    private String producer;
    private Integer customerId;
    Set<Integer> parkings;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public Set<Integer> getParkings() {
        return parkings;
    }

    public void setParkings(Set<Integer> parkings) {
        this.parkings = parkings;
    }
}
