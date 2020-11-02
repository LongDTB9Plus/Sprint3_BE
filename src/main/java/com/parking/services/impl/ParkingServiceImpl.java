package com.parking.services.impl;

import com.parking.models.DAO.Parking;
import com.parking.repositories.ParkingRepository;
import com.parking.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    ParkingRepository parkingRepository;
    @Override
    public Parking findParkingByLicense(String license) {
        return parkingRepository.findAllByCar_License(license);
    }

    @Override
    public Parking findParkingById(Integer id) {
        return parkingRepository.findById(id).orElse(null);
    }

    @Override
    public void saveNewParking(Parking parking) {
        parkingRepository.save(parking);
    }
}
