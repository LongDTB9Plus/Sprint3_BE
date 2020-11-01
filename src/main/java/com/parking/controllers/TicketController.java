package com.parking.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.parking.models.DAO.Ticket;
import com.parking.models.DTO.TicketDTO;
import com.parking.models.converters.TicketConverter;
import com.parking.services.CustomerService;
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


/**
 * Author: Thien
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TicketConverter ticketConverter;

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "all")
    public ResponseEntity<List<TicketDTO>> findAllTicket() {
        List<TicketDTO> result = ticketService
                .findAllTicket()
                .stream()
                .map(ticket -> ticketConverter.convertToTicketDTO(ticket))
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get/{lisence}")
    public ResponseEntity<String> findAllTicket2(@PathVariable String lisence) {
        return ResponseEntity.ok(customerService.findCustomerNameByCarLicense(lisence));
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

    @GetMapping(value = "test")
    public String test() {
        return "Success!";
    }

//    quan
    @GetMapping(value = "{id}")
    public ResponseEntity<TicketDTO> findTicketById(@PathVariable int id){
        return new ResponseEntity<>(ticketService.getById(id), HttpStatus.OK);
    }
}
