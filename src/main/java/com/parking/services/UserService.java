package com.parking.services;


import com.parking.models.security.user.User;
import com.parking.models.security.user.UserDTO;

import java.util.List;


public interface UserService {
    List<User> findAll();
    void save(UserDTO userDto);

}


