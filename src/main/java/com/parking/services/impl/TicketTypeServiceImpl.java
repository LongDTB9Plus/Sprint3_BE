package com.parking.services.impl;

import java.util.List;

import com.parking.models.DAO.TicketType;
import com.parking.repositories.TicketTypeRepository;
import com.parking.services.TicketTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Thien
 */
@Service
public class TicketTypeServiceImpl implements TicketTypeService {

  @Autowired
  TicketTypeRepository ticketTypeRepository;

  @Override
  public void save(TicketType ticketType) {
    ticketTypeRepository.save(ticketType);
  }

  @Override
  public List<TicketType> findAll() {
    return ticketTypeRepository.findAll();
  }

  @Override
  public void edit(Integer ticketTypeId) {
    // TODO Auto-generated method stub

  }

  @Override
  public TicketType findByDetail(String detail) {
    return ticketTypeRepository.findByDetail(detail);
  }
}
