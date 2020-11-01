package com.parking.models.DTO;

import javax.validation.constraints.NotNull;

import lombok.Data;

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
  private String license;

  // @NotNull
  // private String location;

  // @NotNull
  // private String zone;
  
  @NotNull
  private Integer carId;


  
}
