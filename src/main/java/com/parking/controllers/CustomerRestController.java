package com.parking.controllers;

import com.parking.models.DTO.CustomerDTO;
import com.parking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/all-customer")
    public ResponseEntity<List<CustomerDTO>> getListCustomer(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerId(@PathVariable int id){
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }
    @PostMapping("add-customer")
    public ResponseEntity<Void> create(@RequestBody CustomerDTO customerDTO){
        if (customerService.checkCustomerEmailAndPhoneNumber(customerService.convertToCustomer(customerDTO))){
            customerService.saveCustomer(customerDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    @DeleteMapping("delete-customer/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
