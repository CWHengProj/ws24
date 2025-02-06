package com.ws24.ws24.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws24.ws24.Repository.RedisRepo;

@Service
public class RedisService {
    @Autowired
    RedisRepo redisRepo;

    public List<String> getRegistrationList() {
        return redisRepo.getRegistrationList();
    }
}
