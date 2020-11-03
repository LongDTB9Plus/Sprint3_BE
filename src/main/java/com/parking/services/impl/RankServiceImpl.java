package com.parking.services.impl;

import com.parking.models.DAO.Rank;
import com.parking.repositories.RankRepository;
import com.parking.services.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    RankRepository rankRepository;

    @Override
    public Rank findById(Integer id) {
        return rankRepository.findById(id).orElse(null);
    }
}
