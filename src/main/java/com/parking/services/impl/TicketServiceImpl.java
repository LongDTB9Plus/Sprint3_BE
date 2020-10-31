package com.parking.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.parking.models.DAO.Ticket;
import com.parking.models.DTO.TicketDTO;
import com.parking.repositories.TicketRepository;
import com.parking.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Thien
 */
@Service
public class TicketServiceImpl implements TicketService {

  @Autowired
  TicketRepository ticketRepository;

  @Override
  public List<TicketDTO> findAllTicket() {
    return ticketRepository.findAll().stream().map(this::parseTicketToDTO).collect(Collectors.toList());
  }

  @Override
  public Optional<Ticket> findTicketById(Integer ticketId) {
    return ticketRepository.findById(ticketId);
  }

  @Override
  public void createTicket(TicketDTO ticketDTO) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editTicket(TicketDTO ticketDTO) {
    // TODO Auto-generated method stub
  }

  @Override
  public void deleteTicket(Integer ticketId) {
      // TODO Auto-generated method stub
  }

  @Override
  public Ticket parseDTOtoTicket(TicketDTO ticketDTO) {
    return null;
  }

  @Override
  public TicketDTO parseTicketToDTO(Ticket ticket) {
    return null;
  }
  
}
