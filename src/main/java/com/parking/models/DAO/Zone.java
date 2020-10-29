package com.parking.models.DAO;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idZone;

    private String zoneName;

    private Integer positionX;
    private Integer positionY;
    private Integer direction;

    @ManyToOne
    @JoinColumn(name="floor_idFloor", nullable=false)
    private Floor floor;

    @OneToMany(mappedBy="zone")
    private Set<ParkingLot> listParkingLot;

    public Zone() {
    }

    public Integer getIdZone() {
        return idZone;
    }

    public void setIdZone(Integer idZone) {
        this.idZone = idZone;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Set<ParkingLot> getListParkingLot() {
        return listParkingLot;
    }

    public void setListParkingLot(Set<ParkingLot> listParkingLot) {
        this.listParkingLot = listParkingLot;
    }
}
