package com.parking.services;

import com.parking.models.DAO.Car;
import com.parking.models.DAO.Customer;
import com.parking.models.DTO.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();

    CustomerDTO findById(int id);

    void saveCustomer(CustomerDTO customerDTO);

    Integer saveNewCustomer(Customer customer);

    Boolean checkCustomerEmailAndPhoneNumber(Customer customer);

    CustomerDTO convertToCustomerDto(Customer customer);

    Customer convertToCustomer(CustomerDTO customerDTO);

    void delete(int id);


    Customer findCustomerByCar(Car car);
    /**
     *
     * @author: Thien ~ Query get customer name by car license
     */
    String findCustomerNameByCarLicense(String license);

    List<Customer> findAllCustomer();

}
