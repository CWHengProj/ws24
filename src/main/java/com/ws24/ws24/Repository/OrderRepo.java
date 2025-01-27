package com.ws24.ws24.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class OrderRepo {
    //perform adding the user form into the database
    @Autowired
    JdbcTemplate template;
    public Boolean addOrder(MultiValueMap<String,String> data) {
        
        return null;
    }

    
    
}
