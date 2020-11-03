package com.parking.services.impl;

import java.util.Set;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.parking.models.DAO.Ticket;
import com.parking.models.DTO.TicketDTO;
import com.parking.models.constant.ETicketStatus;
import com.parking.models.converters.TicketConverter;
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

  @Autowired
  TicketConverter ticketConverter;

  @Override
  public List<Ticket> findAllTicket() {
    List<Ticket> ticketList = ticketRepository.findAll();
    ticketList.removeIf(ticket -> !ticket.getTicketStatus().equalsIgnoreCase(ETicketStatus.TICKET_ENABLE.name()));
    return ticketList;
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
      Optional<Ticket> ticket = ticketRepository.findById(ticketId);
      ticket.ifPresent(value -> {
        value.setTicketStatus(ETicketStatus.TICKET_DELETED.name());
        ticketRepository.save(value);
      });
  }

  @Override
  public Ticket parseDTOtoTicket(TicketDTO ticketDTO) {
    return null;
  }

  @Override
  public TicketDTO parseTicketToDTO(Ticket ticket) {
    return ticketConverter.convertToTicketDTO(ticket);
  }

  @Override
  public Set<Integer> findTicketByLicense(String license) {
    return ticketRepository.findTicketByLicense(license);
  }


  //quan
  @Override
  public TicketDTO getById(int id) {
    return ticketRepository.findById(id).map(this::parseTicketToDTO).orElse(null);
  }

}
