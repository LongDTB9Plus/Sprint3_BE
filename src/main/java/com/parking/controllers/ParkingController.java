package com.parking.controllers;

import com.parking.models.DAO.*;
import com.parking.services.CarService;
import com.parking.services.ParkingLotService;
import com.parking.services.ParkingService;
import com.parking.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
public class ParkingController {

    @Autowired
    ParkingService parkingService;

    @Autowired
    TicketService ticketService;

    @Autowired
    ParkingLotService parkingLotService;

    @Autowired
    CarService carService;

    @GetMapping(value = "check-in/{license}")
    public ResponseEntity checkCarIn(@PathVariable String license) {
        Car carIn = carService.findCarByLicense(license);
        ParkingRe parkingRe = new ParkingRe();
        parkingRe.setLicense(license);
        if (carIn != null) {
            parkingRe.setCustomerName(carIn.getCustomer().getNameCustomer());
            parkingRe.setCustomerEmail(carIn.getCustomer().getEmail());
            Optional<Ticket> ticketExist = ticketService.findAllByCar_LicenseAndAndTicketStatus(license, "TICKET_ENABLE");
            if (ticketExist.isPresent()) {
                parkingRe.setTicketId(ticketExist.get().getTicketId());
                Optional<ParkingLot> parkingLot = parkingLotService.findAllByTicket_TicketIdAndStatusParkingLot(ticketExist.get().getTicketId(), true);
                parkingLot.ifPresent(lot -> parkingRe.setParkingLotDTO(parkingLotService.convertParkingLotToDTO(lot)));
            }
            return new ResponseEntity<ParkingRe>(parkingRe, HttpStatus.OK);
        }
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "check-out/{license}")
    public ResponseEntity checkCarOut (@PathVariable String license) {
        Parking parking = parkingService.findParkingByLicense(license);
        ParkingRe parkingRe = new ParkingRe();
        parkingRe.setLicense(license);
        if (parking != null) {
            Optional<Ticket> ticket = ticketService.findAllByCar_LicenseAndAndTicketStatus(license, "TICKET_ENABLE");
            if (ticket.isPresent()) {
                ZonedDateTime zonedDateTime = ZonedDateTime.parse(ticket.get().getStartDate());
                parkingRe.setDateStart(zonedDateTime);
                System.out.println(parkingRe.getDateStart());
                zonedDateTime = ZonedDateTime.parse(ticket.get().getEndDate());
                parkingRe.setDateEnd(zonedDateTime);
                Optional<ParkingLot> parkingLot = parkingLotService.findAllByTicket_TicketIdAndStatusParkingLot(ticket.get().getTicketId(), false);
                parkingLot.ifPresent(lot -> parkingRe.setParkingLotDTO(parkingLotService.convertParkingLotToDTO(lot)));
            }
            return new ResponseEntity<ParkingRe>(parkingRe, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
