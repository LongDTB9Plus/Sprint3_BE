package com.parking.repositories;

import com.parking.models.DAO.Parking;
import com.parking.models.DTO.ParkingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;
import java.util.List;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {
    Parking findAllByCar_License(String license);

// Chau

    @Query(
            value = "SELECT count(date_in), date_in \n" +
                    " FROM parking_lot_sprint3.parking\n" +
                    "where (date_in >= ?1 and date_in <= ?2)\n" +
                    "group by (date_in)",nativeQuery = true
    )
    List<String[]> getAllCarByDateIn(String dateStart, String dateEnd);

    @Query(
            value = "SELECT count(date_out), date_out \n" +
                    " FROM parking_lot_sprint3.parking\n" +
                    "where (date_out >= ?1 and date_out <= ?2)\n" +
                    "group by (date_out)",nativeQuery = true
    )
    List<String[]> getAllCarByDateOut(String dateStart, String dateEnd);
}
