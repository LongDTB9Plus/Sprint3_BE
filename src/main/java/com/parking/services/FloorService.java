package com.parking.services;

import com.parking.models.DAO.Floor;
import com.parking.models.DAO.Zone;
import com.parking.models.DTO.FloorDTO;

import java.util.List;

public interface FloorService {
    List<FloorDTO> getAllFloorDTO();
    void addFloor(Floor floor);
    void deleteFloor(Integer id);
}
