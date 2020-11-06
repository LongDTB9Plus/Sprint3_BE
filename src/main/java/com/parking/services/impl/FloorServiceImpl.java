package com.parking.services.impl;

import com.parking.models.DAO.Floor;
import com.parking.models.DAO.Zone;
import com.parking.models.DTO.FloorDTO;
import com.parking.repositories.FloorRepository;
import com.parking.repositories.ParkingLotRepository;
import com.parking.repositories.ZoneRepository;
import com.parking.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Override
    public List<FloorDTO> getAllFloorDTO() {
        return floorRepository.findAll().stream().map(this::convertFloorToDTO).collect(Collectors.toList());
    }

    @Override
    public void addFloor(Floor floor) {
        floorRepository.save(floor);
    }

    @Override
    public void deleteFloor(Integer id) {
        floorRepository.deleteById(id);
    }

    @Override
    public List<Floor> getAllFloor() {
        return floorRepository.findAll();
    }

    @Override
    public Integer getCountOfFloor() {
        return (int) floorRepository.count();
    }

    @Override
    public Floor findById(Integer id) {
        return floorRepository.findById(id).orElse(null);
    }

    private FloorDTO convertFloorToDTO(Floor floor) {
        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setId(floor.getIdFloor());

        List<Integer> arrIdZone = new ArrayList<>();
        for (Zone zone : floor.getListZone()) {
            arrIdZone.add(zone.getIdZone());
        }
        floorDTO.setListZone(arrIdZone);
        List<String> arrZoneName = new ArrayList<>();
        for (Zone zone : floor.getListZone()) {
            arrZoneName.add(zone.getZoneName());
        }
        floorDTO.setListZoneName(arrZoneName);
        floorDTO.setName(floor.getNameFloor());
        return floorDTO;
    }
}
