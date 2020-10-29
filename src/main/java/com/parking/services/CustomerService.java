package com.parking.services;

import com.parking.models.DTO.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CustomerService {
    List<CustomerDTO> findAll();
    CustomerDTO findById(int id);
    void saveCustomer(CustomerDTO customerDTO);

}