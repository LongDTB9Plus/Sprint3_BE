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

//  @NotNull
//  private Set<Integer> parkingLots;

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

  public String getTickTypeDetail() {
    return tickTypeDetail;
  }

  public void setTickTypeDetail(String tickTypeDetail) {
    this.tickTypeDetail = tickTypeDetail;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Set<Integer> getParkingLots() {
    return parkingLots;
  }

  public void setParkingLots(Set<Integer> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Set<String> getCarPlates() {
    return carPlates;
  }

  public void setCarPlates(Set<String> carPlates) {
    this.carPlates = carPlates;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
}
