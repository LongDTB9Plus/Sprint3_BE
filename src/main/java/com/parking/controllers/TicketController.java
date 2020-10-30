package com.parking.controllers;

import java.util.List;

import com.parking.models.DTO.TicketDTO;
import com.parking.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Author: Thien
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/ticket")
public class TicketController {

  @Autowired
  TicketService ticketService;

  @GetMapping(value = "all")
  public ResponseEntity<List<TicketDTO>> findAllTicket() {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(value = "find/{ticketId}")
  public ResponseEntity<Void> findTicketById(@PathVariable Integer ticketId) {
    return null;
  }

  @PostMapping(value = "create")
  public ResponseEntity<Void> createTicked(@RequestBody TicketDTO ticketDTO) {
    return null;
  }

  @PutMapping(value = "edit")
  public ResponseEntity<Void> editTicket(@RequestBody TicketDTO ticketDTO) {
    return null;
  }

  @DeleteMapping(value = "delete/{ticketId")
  public ResponseEntity<Void> deleteTicketById(@PathVariable Integer ticketId) {
    return null;
  }

  @GetMapping(value = "expired")
  public ResponseEntity<Void> handlingExpiredTicket(@RequestBody TicketDTO ticketDTO) {
    return null;
  }

  @GetMapping(value="test")
  public String test() {
      return "Success!";
  }
}
