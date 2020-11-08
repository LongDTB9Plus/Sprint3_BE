package com.parking.services;

import com.parking.models.DAO.ParkingLot;
import com.parking.models.DTO.ParkingLotDTO;

import java.util.List;
import java.util.Optional;

public interface ParkingLotService {
    List<ParkingLotDTO> getAllParkingLot();
    void addParkingLot(ParkingLot parkingLot);
    void deleteParkingLot(Integer id);
    boolean checkParkingLotStatus(Integer id);

    /**
     * @author: Thien
     */
    ParkingLotDTO findById(Integer id);

    Optional<ParkingLot> findParkingLotEntityById(Integer id);

    Optional<ParkingLot> findAllByTicket_TicketIdAndStatusParkingLot(Integer ticketId, Boolean statusParkingLot);
    public ParkingLotDTO convertParkingLotToDTO(ParkingLot parkingLot);
    void save(ParkingLot parkingLot);
}
