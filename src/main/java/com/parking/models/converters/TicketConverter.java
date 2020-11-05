package com.parking.models.converters;

import com.parking.models.DAO.*;
import com.parking.models.DTO.ParkingLotDTO;
import com.parking.models.DTO.TicketDTO;
import com.parking.repositories.CarRepository;
import com.parking.repositories.ParkingLotRepository;
import com.parking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TicketConverter {

    @Autowired
    CarService carService;

    @Autowired
    ParkingLotService parkingLotService;

    @Autowired
    CustomerService customerService;

    @Autowired
    TicketTypeService ticketTypeService;

    @Autowired
    ZoneService zoneService;

    public Ticket convertToTicket(TicketDTO ticketDTO) {
        Ticket ticketResponse = new Ticket();
        TicketType type = ticketTypeService.findByDetail(ticketDTO.getTicketTypeDetail());
        Car car = carService.findCarByLicense(ticketDTO.getCarPlate());

        Optional<Zone> zoneOptional = zoneService.findByZoneName(ticketDTO.getZoneName());

        ParkingLot lot = new ParkingLot();
        lot.setStatusParkingLot(true);
        lot.setTicket(ticketResponse);

        zoneOptional.ifPresent(lot::setZone);

        Set<ParkingLot> parkingLots = new HashSet<>();
        parkingLots.add(lot);


        ticketResponse.setStartDate(ticketDTO.getStartDate());
        ticketResponse.setEndDate(ticketDTO.getEndDate());
        ticketResponse.setTicketStatus(ticketDTO.getTicketStatus());
        ticketResponse.setTicketType(type);
        ticketResponse.setParkingLots(parkingLots);
        ticketResponse.setCar(car);

        return ticketResponse;
    }

    public TicketDTO convertToTicketDTO(Ticket ticket) {
        ParkingLotDTO parkingLotDTO = parkingLotService.findById(ticket.getTicketId());
        TicketDTO ticketDTOResponse = new TicketDTO();

        ticketDTOResponse.setPrice(ticket.getTicketType().getPrice());
        ticketDTOResponse.setCarPlate(ticket.getCar().getLicense());
        ticketDTOResponse.setStartDate(ticket.getStartDate());
        ticketDTOResponse.setEndDate(ticket.getEndDate());
        ticketDTOResponse.setTicketStatus(ticket.getTicketStatus());
        ticketDTOResponse.setTicketTypeDetail(ticket.getTicketType().getDetail());
        ticketDTOResponse.setTicketId(ticket.getTicketId());
        ticketDTOResponse.setCustomerName(ticket.getCar().getCustomer().getNameCustomer());
        ticketDTOResponse.setParkingLot(parkingLotDTO.getId());
        ticketDTOResponse.setZoneName(parkingLotDTO.getNameZone());
        ticketDTOResponse.setFloorName(parkingLotDTO.getNameFloor());

        return ticketDTOResponse;
    }
}
