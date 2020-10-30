package com.parking.models.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Author: Thien
 */
@Data
@Entity
@Table(name = "ticket")
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketid;

  @Column
  private String startDate;

  @Column
  private String endDate;

  @Column
  private String ticketStatus;
  
  
}
