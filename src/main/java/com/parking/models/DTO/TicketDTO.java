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
}
