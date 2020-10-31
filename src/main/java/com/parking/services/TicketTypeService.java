package com.parking.services;

import java.util.List;

import com.parking.models.DAO.TicketType;

import org.springframework.stereotype.Service;

/**
 * Author: Thien
 */
@Service
public interface TicketTypeService {

  List<TicketType> findAll();

  void save(TicketType ticketType);
  
}
