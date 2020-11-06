package com.parking;

import com.parking.models.DAO.*;
import com.parking.models.constant.ETicketPrice;
import com.parking.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingApplication implements ApplicationRunner {

    @Autowired
    TicketTypeService ticketTypeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    CarService carService;

    @Autowired
    FloorService floorService;

    @Autowired
    ZoneService zoneService;

    @Autowired
    ParkingLotService parkingLotService;

    public static void main(String[] args) {
        SpringApplication.run(ParkingApplication.class, args);
    }

    /**
     * Author: Thien ~ Init data for types of ticket table in database
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (ticketTypeService.findAll().isEmpty()) {
            String[] details = {
                    "vip-hour",
                    "vip-day",
                    "vip-week",
                    "vip-month",
                    "normal-hour",
                    "normal-day",
                    "normal-week",
                    "normal-month",
            };

            double[] prices = {
                    ETicketPrice.VIP_HOUR.getPrice(),
                    ETicketPrice.VIP_DAY.getPrice(),
                    ETicketPrice.VIP_WEEK.getPrice(),
                    ETicketPrice.VIP_MONTH.getPrice(),
                    ETicketPrice.NORMAL_HOUR.getPrice(),
                    ETicketPrice.NORMAL_DAY.getPrice(),
                    ETicketPrice.NORMAL_WEEK.getPrice(),
                    ETicketPrice.NORMAL_MONTH.getPrice()
            };

            for (int i = 0; i < details.length; i++) {
                TicketType type = new TicketType();
                type.setDetail(details[i]);
                type.setPrice(prices[i]);

                ticketTypeService.save(type);
            }
        }
//        fake data customer
        if (customerService.findAllCustomer().isEmpty()) {
//            Customer data 1
            {
                Customer test1 = new Customer();
                test1.setAddress("Da Nang");
                test1.setBirthday("24/08/1993");
                test1.setEmail("alexsama2408@gmail.com");
                test1.setGender("Male");
                test1.setIdCard("123456789");
                test1.setNameCustomer("Alex");
                test1.setPhone("0941286408");
                Integer customerId = customerService.saveNewCustomer(test1);
                test1.setId(customerId);
//           Customer datat 2
                Customer test2 = new Customer();
                test2.setAddress("Da Nang");
                test2.setBirthday("14/04/1991");
                test2.setEmail("Janice1404@gmail.com");
                test2.setGender("Female");
                test2.setIdCard("987654321");
                test2.setNameCustomer("Janice");
                test2.setPhone("09323631421");
                Integer customer2Id = customerService.saveNewCustomer(test2);
                test2.setId(customer2Id);
                {
                    Car car = new Car();
                    car.setColor("white");
                    car.setCustomer(test1);
                    car.setLicense("51g92564");
                    car.setType("Sedan");
                    car.setProducer("Nissan");
                    carService.addNewCar(car);
                }
                {
                    Car car1 = new Car();
                    car1.setColor("white");
                    car1.setCustomer(test1);
                    car1.setLicense("51f88838");
                    car1.setType("Sport");
                    car1.setProducer("Lamborghini");
                    carService.addNewCar(car1);
                }
                {
                    Car car = new Car();
                    car.setColor("black");
                    car.setCustomer(test2);
                    car.setLicense("43a27208");
                    car.setType("Sedan");
                    car.setProducer("Mercedes");
                    carService.addNewCar(car);
                }
                {
                    Car car = new Car();
                    car.setColor("white");
                    car.setCustomer(test1);
                    car.setLicense("30a88888");
                    car.setType("Hybrid");
                    car.setProducer("Lexus");
                    carService.addNewCar(car);
                }
            }


        }

//        Dữ liệu bãi đỗ xe
        if (floorService.getAllFloor().isEmpty()) {
            Floor floor = new Floor();
            floor.setNameFloor("Tầng 1");
            floorService.addFloor(floor);
            {
                Zone zone = new Zone();
                zone.setPositionX(10);
                zone.setPositionY(10);
                zone.setFloor(floor);
                zone.setDirection(0);
                zone.setZoneName("Khu A");
                zoneService.addZone(zone);
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone);
                    parkingLot.setStatusParkingLot(false);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone);
                    parkingLot.setStatusParkingLot(false);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
            }

            {
                Zone zone2 = new Zone();
                zone2.setPositionX(500);
                zone2.setPositionY(10);
                zone2.setFloor(floor);
                zone2.setDirection(1);
                zone2.setZoneName("Khu B");
                zoneService.addZone(zone2);
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone2);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone2);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone2);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone2);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone2);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
                {
                    ParkingLot parkingLot = new ParkingLot();
                    parkingLot.setZone(zone2);
                    parkingLot.setStatusParkingLot(true);
                    parkingLotService.addParkingLot(parkingLot);
                }
            }
        }
    }
}
