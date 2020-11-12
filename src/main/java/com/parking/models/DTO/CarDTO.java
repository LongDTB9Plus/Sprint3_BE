package com.parking.models.DTO;

import java.util.List;
import java.util.Set;

public class CarDTO {
    private Integer carId;
    private String license;
    private String color;
    private String producer;
    private Integer customerId;
    private String type;
    Set<Integer> parkings;
    private Set<Integer> ticket;
    private List<String> ticketStatusList;

    public List<String> getticketStatusList() {
        return ticketStatusList;
    }

    public void setticketStatusList(List<String> ticketStatusList) {
        this.ticketStatusList = ticketStatusList;
    }

    public Set<Integer> getTicket() {
        return ticket;
    }

    public void setTicket(Set<Integer> ticket) {
        this.ticket = ticket;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
