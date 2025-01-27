package com.ws24.ws24.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import com.ws24.ws24.Repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Transactional
    public Boolean addOrder(MultiValueMap<String,String> data){
        //perform rollback if there is any issue with orderRepo.addOrder
        if (!orderRepo.addOrder(data)){
            throw new RuntimeException("Something went wrong");
        }
        return true;
    }

}
