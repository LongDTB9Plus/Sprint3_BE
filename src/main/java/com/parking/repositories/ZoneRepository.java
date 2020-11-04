package com.parking.repositories;

import com.parking.models.DAO.Floor;
import com.parking.models.DAO.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    List<Zone> getZonesByFloor(Floor floor);

    /**
     * @author Thien: Declare query find zone by zone name
     */
    Optional<Zone> findByZoneName(String zoneName);
}
