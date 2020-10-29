package com.parking.services;
import com.parking.models.DAO.Car;
import com.parking.models.DTO.CarDTO;
import java.util.List;

public interface CarService {
    List<CarDTO> findAll();
    CarDTO findById(int id);
    void save(CarDTO carDTO);
    void delete(int id);
    Car findCarByLicense(String license);
    Car findCarById(Integer id);
  Integer addNewCar(Car car);

}


