package com.parking.services.impl;

import com.parking.models.security.user.User;
import com.parking.models.security.user.UserDTO;
import com.parking.repositories.UserRepository;
import com.parking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    private User convertToUser(UserDTO userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setFullName(userDto.getFullName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setBirthday(userDto.getBirthday());
        user.setAddress(userDto.getAddress());
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void save(UserDTO userDto) {
        userRepository.save(convertToUser(userDto));
    }

}
