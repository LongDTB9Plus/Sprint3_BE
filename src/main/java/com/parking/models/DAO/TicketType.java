package com.parking.models.DAO;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

/**
 * Author: Thien
 */
@Entity
@Data
@Table(name = "ticket_type")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "ticketTypeId"
)
public class TicketType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketTypeId;

  @Column
  private String detail;

  @Column
  private double price;

  @JsonIgnore
  @OneToMany(mappedBy = "ticketType", fetch = FetchType.LAZY)
  private Set<Ticket> tickets;

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

  public Set<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(Set<Ticket> tickets) {
    this.tickets = tickets;
  }
}
