package com.parking.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.parking.models.DAO.ParkingLot;
import com.parking.models.DAO.Ticket;
import com.parking.models.DTO.ParkingLotDTO;
import com.parking.models.DTO.TicketDTO;
import com.parking.models.converters.TicketConverter;
import com.parking.services.CustomerService;
import com.parking.services.ParkingLotService;
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

    @Autowired
    ParkingLotService parkingLotService;

    @GetMapping(value = "all")
    public ResponseEntity<List<TicketDTO>> findAllTicket() {
        List<TicketDTO> result = ticketService
                .findAllTicket()
                .stream()
                .map(ticket -> ticketConverter.convertToTicketDTO(ticket))
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "get-customer-by-lisence/{lisence}")
    public ResponseEntity<String> getCustomerByLisence(@PathVariable String lisence) {
        return ResponseEntity.ok(customerService.findCustomerNameByCarLicense(lisence));
    }

    @GetMapping(value = "get-parking-info/{id}")
    public ResponseEntity<ParkingLotDTO> getParkingLotById(@PathVariable Integer id) {
        return ResponseEntity.ok(parkingLotService.findById(id));
    }

    @PostMapping(value = "create")
    public ResponseEntity<Void> createTicked(@RequestBody TicketDTO ticketDTO) {
        Ticket ticket = ticketConverter.convertToTicket(ticketDTO);
        ticketService.createTicket(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "edit")
    public ResponseEntity<Void> editTicket(@RequestBody TicketDTO ticketDTO) {
        return null;
    }

    @DeleteMapping(value = "delete/{ticketId}")
    public ResponseEntity<Void> deleteTicketById(@PathVariable Integer ticketId) {
        ticketService.deleteTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "ticket-deleted")
    public ResponseEntity<List<TicketDTO>> findTicketDeleted() {
        List<TicketDTO> result = ticketService
                .findTicketDeleted()
                .stream()
                .map(ticket -> ticketConverter.convertToTicketDTO(ticket))
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "expired")
    public ResponseEntity<Void> handlingExpiredTicket(@RequestBody TicketDTO ticketDTO) {
        return null;
    }

    @GetMapping(value = "find-by-license/{license}")
    public ResponseEntity<Set<Integer>> findTicketByLicense(@PathVariable String license) {
        Set<Integer> result = ticketService.findTicketByLicense(license);
        if (result.isEmpty()) {
            ResponseEntity.status(HttpStatus.CONFLICT);
        } else {
            new ResponseEntity<>(result, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //    quan
    @GetMapping(value = "{id}")
    public ResponseEntity<TicketDTO> findTicketById(@PathVariable int id) {
        return new ResponseEntity<>(ticketService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "lot/{id}")
    public ResponseEntity<ParkingLot> findLot(@PathVariable int id) {
        Optional<ParkingLot> parkingLotOptional = parkingLotService.findParkingLotEntityById(id);
        return parkingLotOptional.map(parkingLot -> new ResponseEntity<>(parkingLot, HttpStatus.OK)).orElse(null);
    }

    @GetMapping(value = "get-by-license/{license}")
    public ResponseEntity<Integer> getTicketDataByLicense(@PathVariable String license) {
        Optional<Ticket> checkExist = ticketService.findAllByCar_LicenseAndAndTicketStatus(license, "TICKET_ENABLE");
        return checkExist.map(ticket -> new ResponseEntity<>(ticket.getTicketId(), HttpStatus.ACCEPTED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));
    }
}
