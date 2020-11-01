package com.parking.repositories;

import com.parking.models.DAO.Car;
import com.parking.models.DAO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findAllByEmail (String email);
    Optional<Customer> findAllByPhone (String phone);
    Customer findAllByCars (Car car);
}
