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
  private String tickTypeDetail;

  @NotNull
  private double price;

  @NotNull
  private Set<Integer> parkingLots;

  @NotNull
  private Set<String> carPlates;

  @NotNull
  private String customerName;
}
