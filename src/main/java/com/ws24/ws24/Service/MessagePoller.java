package com.ws24.ws24.Service;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.ws24.ws24.Model.Order;

@Component
public class MessagePoller {
    @Autowired
    @Qualifier("application")
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    OrderService oService;
    @Async
    public void start(String applicationName){
        //instantiate the poller
        //TODO: check if the user already exists in the registrations list and pop it, if not create one.
        
        Runnable poller = ()->{
            ListOperations<String,String> orderList = redisTemplate.opsForList();
            while(true){
                Optional<String> opt = Optional.ofNullable(orderList.rightPop(applicationName, Duration.ofSeconds(5)));
                if (opt.isPresent()){
                    String data = opt.get();
                    Order userOrder = oService.convertFromJsontoOrder(data);
                    try {
                        oService.addOrder(userOrder);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("There is nothing left in the queue.");
                    break;
                }
            }
        };
        Executors.newSingleThreadExecutor().execute(poller);
    }

}
