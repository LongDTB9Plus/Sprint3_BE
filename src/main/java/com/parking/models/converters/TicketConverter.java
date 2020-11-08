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

/**
 * @author Thien
 */
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
        Ticket ticket = new Ticket();
        ticket.setStartDate(ticketDTO.getStartDate());
        ticket.setEndDate(ticketDTO.getEndDate());
        ticket.setTicketStatus(ticketDTO.getTicketStatus());

        Car car = carService.findCarByLicense(ticketDTO.getCarPlate());
        ticket.setCar(car);


        TicketType type = ticketTypeService.findByDetail(ticketDTO.getTicketTypeDetail());
        ticket.setTicketType(type);


        Set<ParkingLot> parkingLotsNew = new HashSet<>();
        Optional<ParkingLot> parkingLotOptional = parkingLotService.findParkingLotEntityById(ticketDTO.getParkingLot());
        parkingLotOptional.ifPresent(parkingLotsNew::add);
        ticket.setParkingLots(parkingLotsNew);

        return ticket;

        /**                             DTO
         *  id                             id
         *  startDate                      startDate
         *  endDate                         endDate
         *  ticketStatus                    ticketStatus
         *
         *
         *  parkingLots: set                  parkingLot, zoneName, floorName: integer -> findById
         *  ticketType: object               ticketTypeDetail -> find query
         *  car: object                     find car by car plate
         *                                  customerName.
         */
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
