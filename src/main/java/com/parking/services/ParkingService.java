package com.parking.services;

import com.parking.models.DAO.Parking;

public interface ParkingService {
    Parking findParkingByLicense(String license);

    Parking findParkingById(Integer id);

    void saveNewParking(Parking parking);
}
