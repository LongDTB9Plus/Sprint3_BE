package com.parking.repositories;

import com.parking.models.DAO.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {
    Parking findAllByCar_License(String license);
}
