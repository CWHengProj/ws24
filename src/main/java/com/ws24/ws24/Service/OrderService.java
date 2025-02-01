package com.ws24.ws24.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws24.ws24.Model.Order;
import com.ws24.ws24.Model.OrderDetails;
import com.ws24.ws24.Repository.OrderDetailsRepo;
import com.ws24.ws24.Repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderDetailsRepo orderDetailsRepo;
    @Transactional
    public void addOrder(Order order) throws Exception{
        int orderId = orderRepo.addOrderGetOrderID(order);

        List<OrderDetails> od = order.getOrderDetailsList();
        orderDetailsRepo.addOrderDetails(od,orderId);
    }

}
