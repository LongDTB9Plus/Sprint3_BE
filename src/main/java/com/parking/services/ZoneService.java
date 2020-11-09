package com.parking.services;

import com.parking.models.DAO.ParkingLot;
import com.parking.models.DAO.Zone;
import com.parking.models.DTO.ZoneDTO;

import java.util.List;
import java.util.Optional;

public interface ZoneService {
    List<ZoneDTO> getAllZoneDTO(Integer id);
    List<ZoneDTO> getAllZoneDTO();
    void addZone(Zone zone);
    void deleteZone(Integer id);

    /**
     * @author Thien: Declare query find zone by zone name
     */
    Optional<Zone> findByZoneName(String zoneName);

    Zone getZoneById(Integer id);
}
