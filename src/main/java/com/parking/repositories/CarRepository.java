package com.parking.repositories;

import com.parking.models.DAO.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findAllByLicense(String license);
}
