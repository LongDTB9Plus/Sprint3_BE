package com.parking.models.DTO;

import java.util.List;

public class FloorDTO {
    private Integer id;
    private String name;
    private List<Integer> listZone;
    private List<String> listZoneName;

    public FloorDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getListZone() {
        return listZone;
    }

    public void setListZone(List<Integer> listZone) {
        this.listZone = listZone;
    }

    public List<String> getListZoneName() {
        return listZoneName;
    }

    public void setListZoneName(List<String> listZoneName) {
        this.listZoneName = listZoneName;
    }
}
