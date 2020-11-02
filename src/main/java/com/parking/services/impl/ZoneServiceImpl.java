package com.parking.services.impl;

import com.parking.models.DAO.ParkingLot;
import com.parking.models.DAO.Zone;
import com.parking.models.DTO.ZoneDTO;
import com.parking.repositories.ZoneRepository;
import com.parking.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public List<ZoneDTO> getAllZoneDTO() {
        return zoneRepository.findAll().stream().map(this::convertZoneToDTO).collect(Collectors.toList());
    }

    @Override
    public void addZone(Zone zone) {
        zoneRepository.save(zone);
    }

    @Override
    public void deleteZone(Integer id) {
        zoneRepository.deleteById(id);
    }

    private ZoneDTO convertZoneToDTO(Zone zone){
        ZoneDTO zoneDTO = new ZoneDTO();
        zoneDTO.setId(zone.getIdZone());
        zoneDTO.setDirection(zone.getDirection());
        zoneDTO.setName(zone.getZoneName());
        zoneDTO.setPositionX(zone.getPositionX());
        zoneDTO.setPositionY(zone.getPositionY());

        List<Integer> arrIdParkingLot = new ArrayList<>();
        for (ParkingLot p : zone.getListParkingLot()) {
            arrIdParkingLot.add(p.getIdParkingLot());
        }
        zoneDTO.setListParkingLot(arrIdParkingLot);
        return zoneDTO;
    }
}
