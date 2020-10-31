package com.parking.repositories;

import com.parking.models.DAO.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Thien
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
  
}
