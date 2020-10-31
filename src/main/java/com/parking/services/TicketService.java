package com.parking.services;

import java.util.List;
import java.util.Optional;

import com.parking.models.DAO.Ticket;
import com.parking.models.DTO.TicketDTO;

/**
 * Author: Thien
 */
public interface TicketService {

  List<TicketDTO> findAllTicket();

  Optional<Ticket> findTicketById(Integer ticketId);

  void createTicket(TicketDTO ticketDTO);

  void editTicket(TicketDTO ticketDTO);

  void deleteTicket(Integer ticketId);

  Ticket parseDTOtoTicket(TicketDTO ticketDTO);

  TicketDTO parseTicketToDTO(Ticket ticket);
}
