package com.ws24.ws24.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.ws24.ws24.Constants.Values;

@Repository
public class RedisRepo {
    @Autowired
    @Qualifier("application")
    RedisTemplate<String,String> redisTemplate;

    public List<String> getRegistrationList() {
        return redisTemplate.opsForList().range(Values.registration, 0, -1);
        
    }
    public void addUsertoRegistrationList(String username){
        List<String> registrationList =redisTemplate.opsForList().range(Values.registration, 0, -1);
        if(registrationList==null||!registrationList.contains(username)){
            redisTemplate.opsForList().leftPush(Values.registration, username);
        }
    }
    public void addUserOrder(String toWho, String userOrder) {
        redisTemplate.opsForList().leftPush(toWho, userOrder);
    }

}
