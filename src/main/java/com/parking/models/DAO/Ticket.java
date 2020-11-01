package com.parking.models.DAO;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

  @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
  private Set<Car> cars;
}
