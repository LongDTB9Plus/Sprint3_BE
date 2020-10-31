package com.parking.services;

import com.parking.models.DAO.ParkingLot;
import com.parking.models.DTO.ParkingLotDTO;

import java.util.List;

public interface ParkingLotService {
    List<ParkingLotDTO> getAllParkingLot();
    void addParkingLot(ParkingLot parkingLot);
    void deleteParkingLot(Integer id);
    boolean checkParkingLotStatus(Integer id);
}
