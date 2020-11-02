package com.parking.controllers;


import com.parking.models.DAO.Car;
import com.parking.models.DAO.Customer;
import com.parking.models.DTO.CustomerDTO;
import com.parking.services.CarService;
import com.parking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CarService carService;
    @GetMapping("/all-customer")
    public ResponseEntity<List<CustomerDTO>> getListCustomer(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerId(@PathVariable int id){
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }
    @PostMapping("add-customer")
    public ResponseEntity<Customer> create(@RequestBody CustomerDTO customerDTO, UriComponentsBuilder builder){
        if (customerService.checkCustomerEmailAndPhoneNumber(customerService.convertToCustomer(customerDTO))){
            customerService.saveCustomer(customerDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/customer/{id}").buildAndExpand(customerDTO.getId()).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    @DeleteMapping("delete-customer/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("find-customer/{license}")
    public ResponseEntity<Customer> findCustomerByCar(@PathVariable String license){
        Car car = carService.findCarByLicense(license);
        if (car != null){
            return new ResponseEntity<>(customerService.findCustomerByCar(car), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
