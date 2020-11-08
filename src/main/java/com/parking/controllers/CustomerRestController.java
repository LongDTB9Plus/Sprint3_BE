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
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add-customer")
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO, UriComponentsBuilder builder){
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
//            return new ResponseEntity<>(car,HttpStatus.OK);
            return new ResponseEntity<>(customerService.findCustomerByCar(car), HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping("/edit-customer")
    public ResponseEntity<CustomerDTO> editCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println("a" + customerDTO.getId());
        List<CustomerDTO> list = customerService.findListCustomerOtherId(customerDTO.getId());
        System.out.println(list);
        for (CustomerDTO customerDTO1: list){
            if (customerDTO1.getEmail().equals(customerDTO.getEmail()) || customerDTO1.getIdCard().equals(customerDTO.getIdCard()) || customerDTO1.getPhone().equals(customerDTO.getPhone())){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/customerByIdCard/{idCard}")
    public ResponseEntity<Customer> findCustomerByIdCard(@PathVariable String idCard){
        return new ResponseEntity<>(customerService.findCustomerByIdCard(idCard),HttpStatus.OK);
    }
}
