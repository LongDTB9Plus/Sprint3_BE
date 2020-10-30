package com.parking.repositories;

import com.parking.models.DAO.TicketType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Thien
 */
@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Integer> {
  
}
