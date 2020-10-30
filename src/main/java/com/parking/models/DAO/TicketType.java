package com.parking.models.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: Thien
 */
@Entity
@Data
@Table(name = "ticket_type")
public class TicketType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketTypeId;

  @Column
  private String detail;

  @Column
  private double price;
  
}
