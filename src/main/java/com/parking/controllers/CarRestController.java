package com.parking.controllers;

import com.parking.models.DAO.Car;
import com.parking.models.DTO.CarDTO;
import com.parking.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarRestController {
    @Autowired
    CarService carService;
//Long
    @GetMapping("get-car/{license}")
    public ResponseEntity<Car> getCarByLicense(@PathVariable String license) {
        Car car = carService.findCarByLicense(license);
        if (car != null){
            return new ResponseEntity<>(car, HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
// Long
    @PostMapping("add-car")
    public ResponseEntity<Integer> addNewCar(@RequestBody CarDTO carDTO){
        Car car = carService.convertToCar(carDTO);
        Integer getID = carService.addNewCar(car);
        if (getID != 0){
            return new ResponseEntity<>(getID ,HttpStatus.CREATED);
        }
        else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
