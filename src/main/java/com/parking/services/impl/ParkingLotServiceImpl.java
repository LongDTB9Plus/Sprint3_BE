package com.parking.services.impl;

import com.parking.models.DAO.ParkingLot;
import com.parking.models.DTO.ParkingLotDTO;
import com.parking.repositories.ParkingLotRepository;
import com.parking.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Override
    public List<ParkingLotDTO> getAllParkingLot() {
        return parkingLotRepository.findAll().stream().map(this::convertParkingLotToDTO).collect(Collectors.toList());
    }

    @Override
    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
    }

    @Override
    public void deleteParkingLot(Integer id) {
        parkingLotRepository.deleteById(id);
    }

    @Override
    public boolean checkParkingLotStatus(Integer id) {
        ParkingLot parkingLot;
        parkingLot = parkingLotRepository.getOne(id);
        return parkingLot.getStatusParkingLot();
    }

    private ParkingLotDTO convertParkingLotToDTO(ParkingLot parkingLot){
        ParkingLotDTO parkingLotDTO = new ParkingLotDTO();
        parkingLotDTO.setId(parkingLot.getIdParkingLot());
        parkingLotDTO.setIdFloor(parkingLot.getFloor().getIdFloor());
        parkingLotDTO.setIdZone(parkingLot.getZone().getIdZone());
        parkingLotDTO.setNameFloor(parkingLot.getFloor().getNameFloor());
        parkingLotDTO.setNameZone(parkingLot.getZone().getZoneName());
        parkingLotDTO.setStatus(parkingLot.getStatusParkingLot());
        return parkingLotDTO;
    }
}
