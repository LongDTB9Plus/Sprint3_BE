package com.parking.models.DAO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idParkingLot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParkingLot;

    private Boolean statusParkingLot;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="idZone")
    private Zone zone;

    /**
     * @author: Thien ~ Setup relationship with [Ticket]
     */
    @ManyToOne(targetEntity = Ticket.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ticketId")
    private Ticket ticket;

    public ParkingLot() {
    }

    public Integer getIdParkingLot() {
        return idParkingLot;
    }

    public void setIdParkingLot(Integer idParkingLot) {
        this.idParkingLot = idParkingLot;
    }

    public Boolean getStatusParkingLot() {
        return statusParkingLot;
    }

    public void setStatusParkingLot(Boolean statusParkingLot) {
        this.statusParkingLot = statusParkingLot;
    }


    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    /**
     * @author: Thien ~ Setup getter setter
     */
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
