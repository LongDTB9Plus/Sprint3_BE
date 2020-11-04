package com.parking.models.DAO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idFloor;

    private String nameFloor;

    @OneToMany(mappedBy="floor")
    private List<Zone> listZone;

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

    public List<Zone> getListZone() {
        return listZone;
    }

    public void setListZone(List<Zone> listZone) {
        this.listZone = listZone;
    }

}
