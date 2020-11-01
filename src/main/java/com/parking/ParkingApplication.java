package com.parking;

import com.parking.models.DAO.TicketType;
import com.parking.models.constant.ETicketPrice;
import com.parking.services.TicketTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingApplication implements ApplicationRunner {

    @Autowired
    TicketTypeService ticketTypeService;
    
    public static void main(String[] args) {
        SpringApplication.run(ParkingApplication.class, args);
    }

    /**
     * Author: Thien ~ Init data for types of ticket table in database
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        if(ticketTypeService.findAll().isEmpty()) {
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

            for(int i = 0; i < details.length; i++) {
                TicketType type = new TicketType();
                type.setDetail(details[i]);
                type.setPrice(prices[i]);

                ticketTypeService.save(type);
            }
        }
    }
}
