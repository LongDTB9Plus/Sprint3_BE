package com.parking.controllers;

import com.parking.models.DAO.Car;
import com.parking.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarRestController {
    @Autowired
    CarService carService;

    @GetMapping("get-car/{license}")
    public ResponseEntity<Car> getCarByLicense(@PathVariable String license) {
        Car car = carService.findCarByLicense(license);
        if (car != null){
            return new ResponseEntity<>(car, HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
