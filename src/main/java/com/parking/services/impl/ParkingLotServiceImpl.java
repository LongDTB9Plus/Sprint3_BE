package com.parking.services.impl;

import com.parking.models.DAO.ParkingLot;
import com.parking.models.DTO.ParkingLotDTO;
import com.parking.repositories.ParkingLotRepository;
import com.parking.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public ParkingLotDTO convertParkingLotToDTO(ParkingLot parkingLot){
        ParkingLotDTO parkingLotDTO = new ParkingLotDTO();
        parkingLotDTO.setId(parkingLot.getIdParkingLot());
        parkingLotDTO.setIdFloor(parkingLot.getZone().getFloor().getIdFloor());
        parkingLotDTO.setIdZone(parkingLot.getZone().getIdZone());
        parkingLotDTO.setNameFloor(parkingLot.getZone().getFloor().getNameFloor());
        parkingLotDTO.setNameZone(parkingLot.getZone().getZoneName());
        parkingLotDTO.setStatus(parkingLot.getStatusParkingLot());
        parkingLotDTO.setDirection(parkingLot.getZone().getDirection());
        return parkingLotDTO;
    }

    @Override
    public void save(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
    }

    /**
     * @author Thien: find parking lot by id
     */
    @Override
    public ParkingLotDTO findById(Integer parkingLotId) {
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingLotId);
        ParkingLotDTO parkingLotDTO = new ParkingLotDTO();
        if(parkingLot.isPresent()) {
            parkingLotDTO = convertParkingLotToDTO(parkingLot.get());
        }
        return parkingLotDTO;
    }

    @Override
    public Optional<ParkingLot> findParkingLotEntityById(Integer id) {
        return parkingLotRepository.findById(id);
    }

    @Override
    public Optional<ParkingLot> findAllByTicket_TicketIdAndStatusParkingLot(Integer ticketId, Boolean statusParkingLot) {
        return parkingLotRepository.findAllByTicket_TicketIdAndStatusParkingLot(ticketId, statusParkingLot);
    }

}
