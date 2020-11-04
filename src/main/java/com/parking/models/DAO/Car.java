package com.parking.models.DAO;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "carId")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private String license;
    private String color;
    private String producer;
//    quan
    @OneToMany(mappedBy = "car",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
//    @JsonBackReference
    private Set<Parking> parkings;

//    quan
    private String type;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;

    /**
     * @author: Thien ~ Setting relationship Car <-> Ticket
     */
    @JsonIgnore
//    quan chỉnh sửa
    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Ticket> tickets;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * 
     * @author: Thien ~ Getter setter
     */
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
