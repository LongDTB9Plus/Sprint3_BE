package com.parking.services;


import com.parking.models.security.user.User;
import com.parking.models.security.user.UserDTO;

import java.util.List;


public interface UserService {
    List<User> findAll();
    User findByUsername(String username);
    void save(UserDTO userDto);

}


