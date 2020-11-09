package com.parking.models.DAO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idZone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idZone;

    private String zoneName;

    private Integer positionX;
    private Integer positionY;
    private Integer direction;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="floor_idFloor")
    private Floor floor;

    @OneToMany(mappedBy="zone", cascade = CascadeType.MERGE)
    private List<ParkingLot> listParkingLot;

    private Integer typeZone;

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

    public List<ParkingLot> getListParkingLot() {
        return listParkingLot;
    }

    public void setListParkingLot(List<ParkingLot> listParkingLot) {
        this.listParkingLot = listParkingLot;
    }

    public Integer getTypeZone() {
        return typeZone;
    }

    public void setTypeZone(Integer typeZone) {
        this.typeZone = typeZone;
    }
}
