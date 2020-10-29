package com.parking.services.impl;

import com.parking.models.DAO.Car;
import com.parking.models.DAO.Parking;
import com.parking.models.DTO.CarDTO;
import com.parking.repositories.CarRepository;
import com.parking.repositories.CustomerRepository;
import com.parking.repositories.ParkingRepository;
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

    Car convertToCar(CarDTO carDTO){
        Car car = new Car();
        car.setCarId(carDTO.getCarId());
        car.setColor(carDTO.getColor());
        car.setCustomer(customerRepository.findById(carDTO.getCustomerId()).orElse(null));
        car.setLicense(carDTO.getLicense());
        Set<Integer> list = carDTO.getParkings();
        Set<Parking> parkings = new HashSet<>();
        for (int id: list){
            parkings.add(parkingRepository.findById(id).orElse(null));
        }
        car.setParkings(parkings);
        return car;
    }
    CarDTO convertToCarDto(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setCarId(car.getCarId());
        carDTO.setColor(car.getColor());
        carDTO.setCustomerId(car.getCustomer().getId());
        carDTO.setLicense(car.getLicense());
        Set<Parking> parkings = car.getParkings();
        Set<Integer> set = new HashSet<>();
        for (Parking parking: parkings){
            set.add(parking.getIdParking());
        }
        carDTO.setParkings(set);
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

    @Override
    public Car findCarByLicense(String license) {
        return carRepository.findAllByLicense(license).orElse(null);
    }

    @Override
    public Car findCarById(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Integer addNewCar(Car car) {
        carRepository.save(car);
        Car getID = carRepository.findAllByLicense(car.getLicense()).orElse(null);
        if (getID != null){
            return getID.getCarId();
        }
        return 0;
    }
}
