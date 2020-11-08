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
                    "group by (date_in)" +
                    "order by (date_in) asc",nativeQuery = true
    )
    List<String[]> getAllCarByDateIn(String dateStart, String dateEnd);

    @Query(
            value = "SELECT count(date_out), date_out \n" +
                    " FROM parking_lot_sprint3.parking\n" +
                    "where (date_out >= ?1 and date_out <= ?2)\n" +
                    "group by (date_out)" +
                    "order by (date_out) asc",nativeQuery = true
    )
    List<String[]> getAllCarByDateOut(String dateStart, String dateEnd);

    @Query(
            value = "select `date`, IFNULL(ngay_vao, 0) as date_in, IFNULL(ngay_ra, 0) as date_out\n" +
                    "from\n" +
                    "(select date_in as `date`\n" +
                    "from parking_lot_sprint3.parking\n" +
                    "union\n" +
                    "select date_out\n" +
                    "from parking_lot_sprint3.parking) as date_search\n" +
                    "left join \n" +
                    "(select count(date_in) as ngay_vao , date_in\n" +
                    "from parking_lot_sprint3.parking\n" +
                    "where (date_in >= ?1 and date_in <= ?2) \n" +
                    "group by(date_in)) as view_date_in\n" +
                    "on date_search.`date` = view_date_in.date_in\n" +
                    "\n" +
                    "left join \n" +
                    "(select count(date_out) as ngay_ra, date_out\n" +
                    "from parking_lot_sprint3.parking\n" +
                    "where (date_out >= ?1 and date_out <= ?2) \n" +
                    "group by(date_out)) as view_date_out\n" +
                    "on date_search.`date` = view_date_out.date_out\n" +
                    "where `date` between ?1 and ?2",nativeQuery = true
    )
    List<String[]> getAllCarByDateInDateOut(String dateStart, String dateEnd);
}
