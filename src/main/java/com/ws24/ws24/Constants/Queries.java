package com.ws24.ws24.Constants;

public class Queries {
    public static final String updateOrder="""
            insert into orders
            (order_date,
            customer_name,
            ship_address,
            notes,
            tax)
            values
            (?,?,?,?,?)
            """;
    public static final String updateOrderDetails="""
                insert into order_details
                (product,
                unit_price,
                discount,
                quantity,
                order_id) 
                values (?,?,?,?,?)
            """;
}
