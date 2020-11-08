package com.parking.models.DAO;

import com.parking.models.DTO.ParkingLotDTO;

import java.time.ZonedDateTime;

public class ParkingRe {
    private Integer idParking;
    private ZonedDateTime dateStart;
    private ZonedDateTime dateEnd;
    private String carType;
    private Boolean status;
    private String customerName;
    private String customerEmail;
    private String license;
    private Integer ticketId;
    private ParkingLotDTO parkingLotDTO;

    public ParkingRe(){

    }

    public ParkingRe(Integer idParking, ZonedDateTime dateStart, ZonedDateTime dateEnd, String carType,
                     Boolean status, String customerName, String customerEmail,
                     String license, Integer ticketId, ParkingLotDTO parkingLotDTO) {
        this.idParking = idParking;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.carType = carType;
        this.status = status;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.license = license;
        this.ticketId = ticketId;
        this.parkingLotDTO = parkingLotDTO;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public ZonedDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(ZonedDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Integer getIdParking() {
        return idParking;
    }

    public void setIdParking(Integer idParking) {
        this.idParking = idParking;
    }

    public ZonedDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(ZonedDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public ParkingLotDTO getParkingLotDTO() {
        return parkingLotDTO;
    }

    public void setParkingLotDTO(ParkingLotDTO parkingLotDTO) {
        this.parkingLotDTO = parkingLotDTO;
    }
}
