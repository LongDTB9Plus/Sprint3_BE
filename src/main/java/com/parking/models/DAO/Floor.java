package com.parking.models.DAO;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idFloor;

    private String nameFloor;

    @OneToMany(mappedBy="floor")
    private Set<Zone> listZone;

    @OneToMany(mappedBy="floor")
    private Set<ParkingLot> listParkingLot;

    public Floor() {
    }

    public Integer getIdFloor() {
        return idFloor;
    }

    public void setIdFloor(Integer idFloor) {
        this.idFloor = idFloor;
    }

    public String getNameFloor() {
        return nameFloor;
    }

    public void setNameFloor(String nameFloor) {
        this.nameFloor = nameFloor;
    }

    public Set<Zone> getListZone() {
        return listZone;
    }

    public void setListZone(Set<Zone> listZone) {
        this.listZone = listZone;
    }

    public Set<ParkingLot> getListParkingLot() {
        return listParkingLot;
    }

    public void setListParkingLot(Set<ParkingLot> listParkingLot) {
        this.listParkingLot = listParkingLot;
    }
}
