package com.parking.services.impl;

import com.parking.models.DAO.Parking;
import com.parking.models.DTO.ParkingDTO;
import com.parking.repositories.ParkingRepository;
import com.parking.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ParkingDTO convertToParkingDTO(Parking parking) {
        ParkingDTO parkingDTO = new ParkingDTO();
        parkingDTO.setIdParking(parking.getIdParking());
        parkingDTO.setDateIn(parking.getDateIn());
        parkingDTO.setDateOut(parking.getDateOut());
        return parkingDTO;
    }
// Chau
    @Override
    public List<String[]> getAllCarByDateIn(String dateStart, String dateEnd) {
        return parkingRepository.getAllCarByDateIn(dateStart, dateEnd);
    }

    @Override
    public List<String[]> getAllCarByDateOut(String dateStart, String dateEnd) {
        return parkingRepository.getAllCarByDateOut(dateStart, dateEnd);
    }

}
