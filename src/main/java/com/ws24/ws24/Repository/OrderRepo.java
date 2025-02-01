package com.ws24.ws24.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ws24.ws24.Constants.Queries;
import com.ws24.ws24.Model.Order;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class OrderRepo {
    @Autowired
    JdbcTemplate template;
    @Transactional
    public int addOrderGetOrderID(Order order) {
        KeyHolder kh = new GeneratedKeyHolder();
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
                PreparedStatement ps = con.prepareStatement(Queries.updateOrder, new String[] {"order_id"});
                ps.setDate(1, order.getOrder_date());
                ps.setString(2, order.getCustomer_name());
                ps.setString(3,order.getShip_address());
                ps.setString(4,order.getNotes());
                ps.setFloat(5,order.getTax());
                return ps;
            }
        };
        template.update(psc,kh);
        return kh.getKey().intValue();
    }

    
    
}
