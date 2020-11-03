package com.parking.repositories;

import com.parking.models.DAO.Floor;
import com.parking.models.DAO.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    List<Zone> getZonesByFloor(Floor floor);
}
