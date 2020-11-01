package com.parking.models.converters;

import com.parking.models.DAO.*;
import com.parking.models.DTO.TicketDTO;
import com.parking.repositories.CarRepository;
import com.parking.repositories.ParkingLotRepository;
import com.parking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TicketConverter {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    CustomerService customerService;

//    public Ticket convertToTicket(TicketDTO ticketDTO) {
//        Ticket ticketResponse = new Ticket();
//        ticketResponse.setTicketId(ticketDTO.getTicketId());
//        ticketResponse.setTicketStatus(ticketDTO.getTicketStatus());
//        ticketResponse.setStartDate(ticketDTO.getStartDate());
//        ticketResponse.setEndDate(ticketDTO.getEndDate());
//
//
//        Set<Car> cars = new HashSet<>();
//        for(Car car: ticketDTO.getCarPlates()) {
//
//        }
//        ticketResponse.setCars(cars);
//
//
//        if (carDTO.getCarId() != 0) {
//            car.setCarId(carDTO.getCarId());
//        }else car.setCarId(null);
//        car.setColor(carDTO.getColor());
//        car.setCustomer(customerRepository.findById(carDTO.getCustomerId()).orElse(null));
//        car.setLicense(carDTO.getLicense());
//        Set<Integer> list = carDTO.getParkings();
//        Set<Parking> parkings = new HashSet<>();
//        for (int id: list){
//            parkings.add(parkingRepository.findById(id).orElse(null));
//        }
//        car.setParkings(parkings);
//
//
//        ticketResponse.setParkingLots();
//
//        ticketResponse.setTicketType();
//
//
//    }

    public TicketDTO convertToTicketDTO(Ticket ticket) {

        /**
         * Thien: Convert set cars to set car plates
         */
        Set<Car> cars = ticket.getCars();
        Set<String> carPlates = new HashSet<>();
        String license = "";
        for(Car car: cars) {
            carPlates.add(car.getLicense());
            license = car.getLicense();
        }

        /**
         * Thien: Convert parking lots set to parking lot id set
         */
        Set<ParkingLot> parkingLots = ticket.getParkingLots();
        Set<Integer> parkingLotIds = new HashSet<>();

        for(ParkingLot lot: parkingLots) {
            parkingLotIds.add(lot.getIdParkingLot());
        }


        String customerName = customerService.findCustomerNameByCarLicense(license);

        TicketDTO ticketDTOResponse = new TicketDTO();

        ticketDTOResponse.setPrice(ticket.getTicketType().getPrice());
        ticketDTOResponse.setParkingLots(parkingLotIds);
        ticketDTOResponse.setCarPlates(carPlates);
        ticketDTOResponse.setStartDate(ticket.getStartDate());
        ticketDTOResponse.setEndDate(ticket.getEndDate());
        ticketDTOResponse.setTicketStatus(ticket.getTicketStatus());
        ticketDTOResponse.setTickTypeDetail(ticket.getTicketType().getDetail());
        ticketDTOResponse.setTicketId(ticket.getTicketId());
        ticketDTOResponse.setCustomerName(customerName);

        return ticketDTOResponse;
    }
}
