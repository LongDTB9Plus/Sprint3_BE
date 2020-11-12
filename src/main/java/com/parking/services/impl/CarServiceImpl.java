package com.parking.services.impl;

import com.parking.models.DAO.Car;
import com.parking.models.DAO.Parking;
import com.parking.models.DAO.Ticket;
import com.parking.models.DTO.CarDTO;
import com.parking.models.constant.ETicketStatus;
import com.parking.repositories.CarRepository;
import com.parking.repositories.CustomerRepository;
import com.parking.repositories.ParkingRepository;
import com.parking.repositories.TicketRepository;
import com.parking.services.CarService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Car convertToCar(CarDTO carDTO) {
        Car car = new Car();
//        Add logic for id in add new and parse situation.
        if (carDTO.getCarId() != 0) {
            car.setCarId(carDTO.getCarId());
        } else car.setCarId(null);
//        car.setCarId(carDTO.getCarId());
        car.setColor(carDTO.getColor());
        car.setCustomer(customerRepository.findById(carDTO.getCustomerId()).orElse(null));
        car.setType(carDTO.getType());
        car.setLicense(carDTO.getLicense());
        Set<Integer> list = carDTO.getParkings();
        Set<Parking> parkings = new HashSet<>();
        for (int id : list) {
            parkings.add(parkingRepository.findById(id).orElse(null));
        }
        car.setParkings(parkings);
        car.setProducer(carDTO.getProducer());

//        if (car.getTickets()==null) {
//            Set<Ticket> ticketsSet = new HashSet<>();
//            Ticket ticket = new Ticket();
//            ticket.setTicketStatus(ETicketStatus.TICKET_UNREGISTER.name());
//            ticketsSet.add(ticket);
//            car.setTickets(ticketsSet);
//        }


        /**
         * @author: Thien: Nếu chỗ này lỗi - Liên hệ Thiện
         */
        Set<Ticket> tickets = new HashSet<>();
        Set<Integer> integers = carDTO.getTicket();
        for (Integer integer : integers) {
            tickets.add(ticketRepository.findById(integer).orElse(null));
        }
        car.setTickets(tickets);

        return car;
    }

    @Override
    public CarDTO convertToCarDto(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setCarId(car.getCarId());
        carDTO.setColor(car.getColor());
        carDTO.setCustomerId(car.getCustomer().getId());
        carDTO.setType(car.getType());
        carDTO.setLicense(car.getLicense());
        Set<Parking> parkings = car.getParkings();
        Set<Integer> set = new HashSet<>();
        List<String> ticketStatusList = new ArrayList<>();

        for (Parking parking : parkings) {
            set.add(parking.getIdParking());
        }
        carDTO.setParkings(set);
        carDTO.setProducer(car.getProducer());
        Set<Ticket> ticketList = car.getTickets();
        Set<Integer> integers = new HashSet<>();
        for (Ticket ticket : ticketList) {
            integers.add(ticket.getTicketId());
            ticketStatusList.add(ticket.getTicketStatus());
        }
        carDTO.setTicket(integers);
        carDTO.setticketStatusList(ticketStatusList);
        return carDTO;
    }

    @Override
    public List<CarDTO> findAll() {
        return carRepository.findAll().stream().map(this::convertToCarDto).collect(Collectors.toList());
    }

    @Override
    public CarDTO findById(int id) {
        return carRepository.findById(id).map(this::convertToCarDto).orElse(null);
    }

    @Override
    public void save(CarDTO carDTO) {
        carRepository.save(convertToCar(carDTO));
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }

    //Long
    @Override
    public Car findCarByLicense(String license) {
        return carRepository.findAllByLicense(license).orElse(null);
    }

    @Override
    public Car findCarById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    //Long
    @Override
    public Integer addNewCar(Car car) {
//        check if car already exist on database base on plate license.
        Car getID = carRepository.findAllByLicense(car.getLicense()).orElse(null);
        if (getID == null) {
            carRepository.save(car);
            getID = carRepository.findAllByLicense(car.getLicense()).orElse(null);
            if (getID != null) {
                return getID.getCarId();
            }
        }
        return 0;
    }

    //quan
    @Override
    public List<CarDTO> findCarByCustomer(int customerId) {
        return carRepository.findAllByCustomer(customerRepository.findById(customerId).orElse(null)).stream().map(this::convertToCarDto).collect(Collectors.toList());
    }

    // Chau
    @Override
    public List<CarDTO> findAllCarByType(String type) {
        return carRepository.findAllByType(type).stream().map(this::convertToCarDto).collect(Collectors.toList());
    }

    //quan
    @Override
    public void editCar(CarDTO carDTO) {
        carRepository.save(convertToCar(carDTO));
    }

    @Override
    public List<Car> findCarByNameCustomer(String customerName) {
        //        cars.removeIf(car -> car.getTickets().removeIf(ticket -> ticket.getTicketStatus().equalsIgnoreCase(ETicketStatus.TICKET_ENABLE.name())));
        return carRepository.findByCustomer_NameCustomer(customerName);
    }


}
