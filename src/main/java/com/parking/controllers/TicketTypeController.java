package com.parking.controllers;

import java.util.List;

import com.parking.models.DAO.TicketType;
import com.parking.services.TicketTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Author: Thien
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/ticket-type")
public class TicketTypeController {

  @Autowired
  TicketTypeService ticketTypeService;
  
  @GetMapping(value="all")
  public ResponseEntity<List<TicketType>> findAllTicketTypes() {
      return ResponseEntity.ok(ticketTypeService.findAll());
  }

  @GetMapping(value="detail/{detail}")
  public ResponseEntity<TicketType> findByDetail(@PathVariable String detail) {
      return ResponseEntity.ok(ticketTypeService.findByDetail(detail));
  }
  

  //for admin

  //change value of type
  // add type
}
