package com.parking.controllers;

import com.parking.models.DAO.Floor;
import com.parking.models.DAO.ParkingLot;
import com.parking.models.DAO.Zone;
import com.parking.models.DTO.FloorDTO;
import com.parking.models.DTO.ParkingLotDTO;
import com.parking.models.DTO.ZoneDTO;
import com.parking.services.FloorService;
import com.parking.services.ParkingLotService;
import com.parking.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParkingLotRestController {
    @Autowired
    private FloorService floorService;

    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private ZoneService zoneService;

    @GetMapping("/getAllParkingLot")
    public ResponseEntity<List<ParkingLotDTO>> getAllParkingLot(){
        return new ResponseEntity<>(parkingLotService.getAllParkingLot(), HttpStatus.OK);
    }

    @GetMapping("/getAllZone")
    public ResponseEntity<List<ZoneDTO>> getAllZone(){
        return new ResponseEntity<>(zoneService.getAllZoneDTO(), HttpStatus.OK);
    }

    @GetMapping("/getAllFloor")
    public ResponseEntity<List<FloorDTO>> getAllFloor(){
        return new ResponseEntity<>(floorService.getAllFloorDTO(), HttpStatus.OK);
    }

    @PostMapping("/saveParkingLot")
    public void saveParkingLot(@RequestBody ParkingLot parkingLot){
        parkingLotService.addParkingLot(parkingLot);
    }

    @PostMapping("/saveZone")
    public void saveZone(@RequestBody Zone zone, @RequestBody List<ParkingLot> parkingLotList){
        zoneService.addZone(zone);
        for (ParkingLot parkingLot: parkingLotList) {
            parkingLotService.addParkingLot(parkingLot);
        }
    }

    @PostMapping("/saveFloor")
    public void saveFloor(@RequestBody Floor floor){
        floorService.addFloor(floor);
    }
}
