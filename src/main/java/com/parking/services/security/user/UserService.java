package com.parking.services.security.user;


import com.parking.models.security.user.User;
import com.parking.models.security.user.UserDTO;

import java.util.List;


public interface UserService {
    List<User> findAll();
    void save(UserDTO userDto);
    User findByUsername(String username);
    Integer countAllBy();
    User findById(Integer id);
    void delete(Integer id);

}


