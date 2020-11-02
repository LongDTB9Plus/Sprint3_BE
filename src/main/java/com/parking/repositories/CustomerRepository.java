package com.parking.repositories;

import com.parking.models.DAO.Car;
import com.parking.models.DAO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    private Optional<Customer> findAllByEmail(String email);
    Optional<Customer> findAllByPhone (String phone);
    Customer findAllByCars (Car car);
    Optional<Customer> findAllByEmail(String email);

    Optional<Customer> findAllByPhone(String phone);

    /**
     *
     * @author: Thien ~ Query get customer name by car license
     */
    @Query(
            value =
                    "select name_customer " +
                    "from parking_lot_sprint3.customer " +
                    "join car on customer.id = car.customer_id " +
                    "where car.license = ?1",
            nativeQuery = true)
    String findCustomerNameByCarLicense(String license);

}
