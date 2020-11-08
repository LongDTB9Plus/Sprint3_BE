package com.parking.repositories;

import com.parking.models.DAO.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

/**
 * Author: Thien
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(value = "select ticket_id from ticket " +
            "join car on ticket.car_id = car.car_id " +
            "where car.license = ?1", nativeQuery = true)
    Set<Integer> findTicketByLicense(String license);

    Optional<Ticket> findAllByCar_LicenseAndAndTicketStatus(String license, String ticketStatus);
}
