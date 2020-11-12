package com.parking.services;

import com.parking.models.DAO.Car;
import com.parking.models.DTO.CarDTO;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<CarDTO> findAll();

    CarDTO findById(int id);

    void save(CarDTO carDTO);

    void delete(int id);

    Car findCarByLicense(String license);

    Car findCarById(Integer id);

    Integer addNewCar(Car car);

    Car convertToCar(CarDTO carDTO);

//    quan
    List<CarDTO> findCarByCustomer(int customerId);

    //Chau
    List<CarDTO> findAllCarByType(String type);

//    quan
    void editCar(CarDTO carDTO);

    List<Car> findCarByNameCustomer(String customerName);
    CarDTO convertToCarDto(Car car);
}


