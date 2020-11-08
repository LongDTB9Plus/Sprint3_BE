package com.parking.controllers;

import com.parking.models.DAO.Car;
import com.parking.models.DTO.CarDTO;
import com.parking.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarRestController {
    @Autowired
    CarService carService;

    //Long
    @GetMapping("get-car/{license}")
    public ResponseEntity<Car> getCarByLicense(@PathVariable String license) {
        Car car = carService.findCarByLicense(license);
        if (car != null) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    // Long
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add-car")
    public ResponseEntity<Integer> addNewCar(@RequestBody CarDTO carDTO) {
        System.out.println("qua chua kia");
        Car car = carService.convertToCar(carDTO);
        Integer getID = carService.addNewCar(car);
        if (getID != 0) {
            return new ResponseEntity<>(getID, HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    //    quan
    @GetMapping("/all-car")
    public ResponseEntity<List<CarDTO>> allCar() {
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
    }

    //    quan
    @GetMapping("car/{id}")
    public ResponseEntity<CarDTO> getCarId(@PathVariable int id) {
        return new ResponseEntity<>(carService.findById(id), HttpStatus.OK);
    }

    //    quan
    @DeleteMapping("delete-car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable int id) {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    quan
    @GetMapping("get-car-by-customer/{id}")
    public ResponseEntity<List<CarDTO>> getCarByCustomer(@PathVariable Integer id) {
        return new ResponseEntity<>(carService.findCarByCustomer(id), HttpStatus.OK);
    }

    // Chau
    @GetMapping("getAllCarByType/{type}")
    public ResponseEntity<List<CarDTO>> getAllCarByType(@PathVariable String type) {
        return new ResponseEntity<>(carService.findAllCarByType(type), HttpStatus.OK);
    }

    //    quan
    @PostMapping("/edit-car")
    public ResponseEntity<Void> editCar(@RequestBody CarDTO carDTO) {
        carService.editCar(carDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
