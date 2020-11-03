package com.parking.repositories;

import com.parking.models.DAO.Car;
import com.parking.models.DAO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findAllByLicense(String license);
    List<Car> findAllByCustomer(Customer customer);
    List<Car> findAllByType(String type);
}
