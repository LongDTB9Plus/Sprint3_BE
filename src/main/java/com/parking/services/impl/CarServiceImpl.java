package com.parking.services.impl;

import com.parking.models.DAO.Car;
import com.parking.models.DAO.Parking;
import com.parking.models.DAO.Ticket;
import com.parking.models.DTO.CarDTO;
import com.parking.repositories.CarRepository;
import com.parking.repositories.CustomerRepository;
import com.parking.repositories.ParkingRepository;
import com.parking.repositories.TicketRepository;
import com.parking.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    public Car convertToCar(CarDTO carDTO){
        Car car = new Car();
//        Add logic for id in add new and parse situation.
        if (carDTO.getCarId() != 0) {
            car.setCarId(carDTO.getCarId());
        }else car.setCarId(null);
        car.setColor(carDTO.getColor());
        car.setCustomer(customerRepository.findById(carDTO.getCustomerId()).orElse(null));
        car.setType(carDTO.getType());
        car.setLicense(carDTO.getLicense());
        Set<Integer> list = carDTO.getParkings();
        Set<Parking> parkings = new HashSet<>();
        for (int id: list){
            parkings.add(parkingRepository.findById(id).orElse(null));
        }
        car.setParkings(parkings);
        car.setProducer(carDTO.getProducer());

        /**
         * @author: Thien: Nếu chỗ này lỗi - Liên hệ Thiện
         */
        Set<Ticket> tickets = new HashSet<>();

        Ticket ticket = ticketRepository.findById(carDTO.getTicket()).orElse(null);
        tickets.add(ticket);
        car.setTickets(tickets);

        return car;
    }
    CarDTO convertToCarDto(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setCarId(car.getCarId());
        carDTO.setColor(car.getColor());
        carDTO.setCustomerId(car.getCustomer().getId());
        carDTO.setType(car.getType());
        carDTO.setLicense(car.getLicense());
        Set<Parking> parkings = car.getParkings();
        Set<Integer> set = new HashSet<>();
        for (Parking parking: parkings){
            set.add(parking.getIdParking());
        }
        carDTO.setParkings(set);
        carDTO.setProducer(car.getProducer());
//        carDTO.setTicket(car.getTicket().getTicketId());
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
}
