package com.parking.services.impl;

import com.parking.models.DAO.Car;
import com.parking.models.DAO.Customer;
import com.parking.models.DTO.CustomerDTO;
import com.parking.repositories.CarRepository;
import com.parking.repositories.CustomerRepository;
import com.parking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CarRepository carRepository;
    @Override
    public CustomerDTO convertToCustomerDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setNameCustomer(customer.getNameCustomer());
        customerDTO.setBirthday(customer.getBirthday());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setGender(customer.getGender());
        customerDTO.setIdCard(customer.getIdCard());
        customerDTO.setAddress(customer.getAddress());
        List<Car> cars = customer.getCars();
        List<Integer> list = new ArrayList<>();
        for (Car car : cars) {
            list.add(car.getCarId());
        }
        customerDTO.setCars(list);
        return customerDTO;
    }
    @Override
    public Customer convertToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setNameCustomer(customerDTO.getNameCustomer());
        customer.setBirthday(customerDTO.getBirthday());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setGender(customerDTO.getGender());
        customer.setIdCard(customerDTO.getIdCard());
        customer.setAddress(customerDTO.getAddress());
        List<Integer> list = customerDTO.getCars();
        List<Car> cars = new ArrayList<>();
        for (int id : list) {
            cars.add(carRepository.findById(id).orElse(null));
        }
        customer.setCars(cars);
        return customer;
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(this::convertToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(int id) {
        return customerRepository.findById(id).map(this::convertToCustomerDto).orElse(null);
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerRepository.save(convertToCustomer(customerDTO));
    }

//    Save new customer and return customer ID of instance just saved. return 0 if saving process failed.
    @Override
    public Integer saveNewCustomer(Customer customer) {
        if (checkCustomerEmailAndPhoneNumber(customer)) {
            customerRepository.save(customer);
//            Get the instance just saved by Email.
            Customer customerJustAdd = customerRepository.findAllByEmail(customer.getEmail()).orElse(null);
            if (customerJustAdd != null) {
                return customerJustAdd.getId();
            }
        }
        return 0;
    }

    // Return False if Email or Phone is exist.
    @Override
    public Boolean checkCustomerEmailAndPhoneNumber(Customer customer) {
        return (customerRepository.findAllByEmail(customer.getEmail()).isEmpty())
                || (customerRepository.findAllByPhone(customer.getPhone()).isEmpty());
    }
}
