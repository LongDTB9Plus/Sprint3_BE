package com.parking.models.DTO;

import java.util.List;

public class ZoneDTO {
    private Integer id;
    private String name;
    private Integer positionX;
    private Integer positionY;
    private Integer direction;
    private Integer idFloor;
    private Integer typeZone;

    private List<Integer> listParkingLot;

    public ZoneDTO() {
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

    public List<Integer> getListParkingLot() {
        return listParkingLot;
    }

    public void setListParkingLot(List<Integer> listParkingLot) {
        this.listParkingLot = listParkingLot;
    }

    public Integer getIdFloor() {
        return idFloor;
    }

    public void setIdFloor(Integer idFloor) {
        this.idFloor = idFloor;
    }

    public Integer getTypeZone() {
        return typeZone;
    }

    public void setTypeZone(Integer typeZone) {
        this.typeZone = typeZone;
    }
}
