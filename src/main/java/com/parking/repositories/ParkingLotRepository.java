package com.parking.repositories;

import com.parking.models.DAO.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {

    Optional<ParkingLot> findAllByTicket_TicketIdAndStatusParkingLot(Integer ticketId, Boolean statusParkingLot);
}
