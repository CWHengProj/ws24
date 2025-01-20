package com.ws24.ws24.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws24.ws24.Repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
}
