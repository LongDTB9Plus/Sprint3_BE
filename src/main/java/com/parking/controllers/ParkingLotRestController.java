package com.parking.controllers;

import com.parking.models.DAO.Floor;
import com.parking.models.DAO.ParkingLot;
import com.parking.models.DAO.Zone;
import com.parking.models.DTO.FloorDTO;
import com.parking.models.DTO.ParkingLotDTO;
import com.parking.models.DTO.ZoneDTO;
import com.parking.services.FloorService;
import com.parking.services.ParkingLotService;
import com.parking.services.ParkingService;
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

    @Autowired
    private ParkingService parkingService;

    @GetMapping("/getAllParkingLot")
    public ResponseEntity<List<ParkingLotDTO>> getAllParkingLot(){
        return new ResponseEntity<>(parkingLotService.getAllParkingLot(), HttpStatus.OK);
    }

    @GetMapping("/getAllZone/{id}")
    public ResponseEntity<List<ZoneDTO>> getAllZoneByFloor(@PathVariable Integer id){
        return new ResponseEntity<>(zoneService.getAllZoneDTO(id), HttpStatus.OK);
    }

    @GetMapping("/getAllFloor")
    public ResponseEntity<List<FloorDTO>> getAllFloor(){
        return new ResponseEntity<>(floorService.getAllFloorDTO(), HttpStatus.OK);
    }

    @PostMapping("/saveParkingLot")
    public void saveParkingLot(@RequestBody ParkingLotDTO parkingLotDTO){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setStatusParkingLot(true);
        parkingLot.setIdParkingLot(parkingLotDTO.getId());
        Zone zone = zoneService.getZoneById(parkingLotDTO.getIdZone());
        parkingLot.setZone(zone);
        parkingLotService.addParkingLot(parkingLot);
    }

    @PostMapping("/editParkingLot")
    public void editParkingLot(@RequestBody ParkingLotDTO parkingLotDTO){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setIdParkingLot(parkingLotDTO.getId());
        if(parkingLotDTO.getStatus().equals("Đã có xe")){
            parkingLot.setStatusParkingLot(false);
        }else {
            parkingLot.setStatusParkingLot(true);
        }
        Zone zone = zoneService.getZoneById(parkingLotDTO.getIdZone());
        parkingLot.setZone(zone);
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

    @GetMapping("/getParkingLotById/{id}")
    public ResponseEntity<ParkingLotDTO> getParkingLotById(@PathVariable Integer id){
        return new ResponseEntity<>(parkingLotService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/getAllCarByDateIn/{dateStart}/{dateEnd}")
    public ResponseEntity<List<String[]>> getAllCarByDateIn(@PathVariable String dateStart, @PathVariable String dateEnd){
        return new ResponseEntity<>(parkingService.getAllCarByDateIn(dateStart, dateEnd),HttpStatus.OK);
    }

    @GetMapping("/getAllCarByDateOut/{dateStart}/{dateEnd}")
    public ResponseEntity<List<String[]>> getAllCarByDateOut(@PathVariable String dateStart, @PathVariable String dateEnd){
        return new ResponseEntity<>(parkingService.getAllCarByDateOut(dateStart, dateEnd),HttpStatus.OK);
    }

    @GetMapping("/getAllCarByDateInDateOut/{dateStart}/{dateEnd}")
    public ResponseEntity<List<String[]>> getAllCarByDateInDateOut(@PathVariable String dateStart, @PathVariable String dateEnd){
        return new ResponseEntity<>(parkingService.getAllCarByDateInDateOut(dateStart, dateEnd),HttpStatus.OK);
    }
}
