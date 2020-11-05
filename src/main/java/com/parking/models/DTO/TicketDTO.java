package com.parking.models.DTO;

import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.Set;

/**
 * Author: Thien
 */
@Data
public class TicketDTO {

  @NotNull
  private Integer ticketId;

  @NotNull
  private String startDate;

  @NotNull
  private String endDate;

  @NotNull
  private String ticketStatus;

  @NotNull
  private String ticketTypeDetail;

  @NotNull
  private double price;

  @NotNull
  private Integer parkingLot;

  @NotNull
  private String floorName;

  @NotNull
  private String zoneName;

  @NotNull
  private String carPlate;

  @NotNull
  private String customerName;

  public Integer getTicketId() {
    return ticketId;
  }

  public void setTicketId(Integer ticketId) {
    this.ticketId = ticketId;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getTicketStatus() {
    return ticketStatus;
  }

  public void setTicketStatus(String ticketStatus) {
    this.ticketStatus = ticketStatus;
  }

  public String getTicketTypeDetail() {
    return ticketTypeDetail;
  }

  public void setTicketTypeDetail(String ticketTypeDetail) {
    this.ticketTypeDetail = ticketTypeDetail;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Integer getParkingLot() {
    return parkingLot;
  }

  public void setParkingLot(Integer parkingLot) {
    this.parkingLot = parkingLot;
  }

  public String getFloorName() {
    return floorName;
  }

  public void setFloorName(String floorName) {
    this.floorName = floorName;
  }

  public String getZoneName() {
    return zoneName;
  }

  public void setZoneName(String zoneName) {
    this.zoneName = zoneName;
  }

  public String getCarPlate() {
    return carPlate;
  }

  public void setCarPlate(String carPlate) {
    this.carPlate = carPlate;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
}
