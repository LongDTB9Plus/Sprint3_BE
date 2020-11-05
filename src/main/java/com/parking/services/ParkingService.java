package com.parking.services;

import com.parking.models.DAO.Parking;
import com.parking.models.DTO.ParkingDTO;

import java.util.List;

public interface ParkingService {
    Parking findParkingByLicense(String license);

    Parking findParkingById(Integer id);

    void saveNewParking(Parking parking);
// Chau
   List<String[]> getAllCarByDateIn(String dateStart, String dateEnd);
   List<String[]> getAllCarByDateOut(String dateStart, String dateEnd);
}
