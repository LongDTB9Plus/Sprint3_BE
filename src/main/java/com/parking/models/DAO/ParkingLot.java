package com.parking.models.DAO;

import javax.persistence.*;

@Entity
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idParkingLot;

    private Boolean statusParkingLot;

    @ManyToOne
    @JoinColumn(name="floor_idFloor", nullable=false)
    private Floor floor;

    @ManyToOne
    @JoinColumn(name="zone_idZone", nullable=false)
    private Zone zone;

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

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
