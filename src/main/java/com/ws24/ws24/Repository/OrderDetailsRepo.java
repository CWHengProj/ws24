package com.ws24.ws24.Repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ws24.ws24.Constants.Queries;
import com.ws24.ws24.Model.OrderDetails;

@Repository
public class OrderDetailsRepo {
    @Autowired
    JdbcTemplate template;
    @Transactional
    public void addOrderDetails(List<OrderDetails> orderDetails, int order_id) throws Exception {
        List<Object[]> args = orderDetails.stream().map(od -> new Object[]{
            od.getProduct(),od.getUnit_price(),od.getDiscount(),
            od.getQuantity(),order_id
        }).collect(Collectors.toList());
        int[] numberAffected = template.batchUpdate(Queries.updateOrderDetails, args);
        for (int i : numberAffected){
            if (i<1){
                throw new Exception("Something went wrong with inserting Order Details.");
            }
        }   
    }
}
