package com.parking.models.DTO;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Author: Thien
 */
@Data
public class TicketDTO {

  @NotNull
  private String startDate;

  @NotNull
  private String endDate;
  
  @NotNull
  private String idCar;


  
}
