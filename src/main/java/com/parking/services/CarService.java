package com.parking.services;

import com.parking.models.DAO.Car;

public interface CarService {
     Car findCarByLicense(String license);
     Car findCarById(Integer id);
     Integer addNewCar(Car car);
}
