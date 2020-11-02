package com.parking.services;

import java.util.List;
import java.util.Optional;

import com.parking.models.DAO.Ticket;
import com.parking.models.DTO.TicketDTO;

/**
 * @author: Thien
 */
public interface TicketService {

  List<Ticket> findAllTicket();

  Optional<Ticket> findTicketById(Integer ticketId);

  void createTicket(TicketDTO ticketDTO);

  void editTicket(TicketDTO ticketDTO);

  void deleteTicket(Integer ticketId);

  Ticket parseDTOtoTicket(TicketDTO ticketDTO);

  TicketDTO parseTicketToDTO(Ticket ticket);

//  quan
  TicketDTO getById(int id);
}
