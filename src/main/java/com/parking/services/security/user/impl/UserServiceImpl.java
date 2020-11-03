package com.parking.services.security.user.impl;

import com.parking.models.DAO.Rank;
import com.parking.models.security.user.User;
import com.parking.models.security.user.UserDTO;
import com.parking.repositories.UserRepository;
import com.parking.services.RankService;
import com.parking.services.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    RankService rankService;

    private User convertToUser(UserDTO userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setBirthday(userDto.getBirthday());
        user.setAddress(userDto.getAddress());
        Rank rank= rankService.findById(userDto.getRank());
        user.setRank(rank);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserDTO userDto) {
        userRepository.save(convertToUser(userDto));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public Integer countAllBy() {
        return userRepository.countAllBy();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

}
