package com.parking.models.DTO;

public class Dto {
    private FloorDTO floorChoose;
    private ZoneDTO zone;

    public Dto() {
    }

    public FloorDTO getFloorChoose() {
        return floorChoose;
    }

    public void setFloorChoose(FloorDTO floorChoose) {
        this.floorChoose = floorChoose;
    }

    public ZoneDTO getZone() {
        return zone;
    }

    public void setZone(ZoneDTO zone) {
        this.zone = zone;
    }
}
