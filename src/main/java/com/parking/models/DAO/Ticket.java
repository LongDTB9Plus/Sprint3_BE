package com.parking.models.DAO;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Author: Thien
 */
@Data
@Entity
@Table(name = "ticket")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "ticketId"
)
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketId;

  @Column
  private String startDate;

  @Column
  private String endDate;

  @Column
  private String ticketStatus;

  @OneToMany(mappedBy = "ticket")
  private Set<ParkingLot> parkingLots;

  @ManyToOne(targetEntity = TicketType.class)
  @JoinColumn(name = "ticketTypeId", nullable = false)
  private TicketType ticketType;

//quan
  @ManyToOne(targetEntity = Car.class, cascade= CascadeType.MERGE)
//
  @JoinColumn(name = "carId")
  private Car car;


  // Đang xài lombok thằng Quân viết cái gì đây ?
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

  public TicketType getTicketType() {
    return ticketType;
  }

  public void setTicketType(TicketType ticketType) {
    this.ticketType = ticketType;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Set<ParkingLot> getParkingLots() {
    return parkingLots;
  }

  public void setParkingLots(Set<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

}
