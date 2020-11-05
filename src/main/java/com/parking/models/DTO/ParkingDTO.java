package com.parking.models.DTO;

import java.time.LocalDateTime;
import java.util.Date;

public class ParkingDTO {
    private Integer idParking;
    private LocalDateTime dateIn;
    private LocalDateTime dateOut;

    public ParkingDTO() {
    }

    public Integer getIdParking() {
        return idParking;
    }

    public void setIdParking(Integer idParking) {
        this.idParking = idParking;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDateTime dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDateTime dateOut) {
        this.dateOut = dateOut;
    }
}
