package com.parking.services.impl;

import com.parking.models.DAO.Car;
import com.parking.models.DAO.Parking;
import com.parking.models.DTO.CarDTO;
import com.parking.repositories.CarRepository;
import com.parking.repositories.CustomerRepository;
import com.parking.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CustomerRepository customerRepository;

    Car convertToCar(CarDTO carDTO){
        Car car = new Car();
        car.setCarId(carDTO.getCarId());
        car.setColor(carDTO.getColor());
        car.setCustomer(customerRepository.findById(carDTO.getCustomerId()).orElse(null));
        car.setLicense(carDTO.getLicense());
        car.setProducer(carDTO.getProducer());
        return car;
    }

    @Override
    public List<CarDTO> findAll() {
        return null;
    }

    @Override
    public CarDTO findById(int id) {
        return null;
    }

    @Override
    public void save(CarDTO carDTO) {

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
