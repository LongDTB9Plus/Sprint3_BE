package com.parking.models.DTO;

import lombok.Data;

@Data
public class TicketTypeDTO {

  private Integer ticketTypeId;

  private String detail;

  private double price;

  public Integer getTicketTypeId() {
    return ticketTypeId;
  }

  public void setTicketTypeId(Integer ticketTypeId) {
    this.ticketTypeId = ticketTypeId;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
