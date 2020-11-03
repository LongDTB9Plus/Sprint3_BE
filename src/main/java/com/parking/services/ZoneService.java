package com.parking.services;

import com.parking.models.DAO.ParkingLot;
import com.parking.models.DAO.Zone;
import com.parking.models.DTO.ZoneDTO;

import java.util.List;

public interface ZoneService {
    List<ZoneDTO> getAllZoneDTO(Integer id);
    void addZone(Zone zone);
    void deleteZone(Integer id);
}
