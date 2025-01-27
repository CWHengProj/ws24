package com.ws24.ws24.Model;

import java.sql.Date;
import java.util.List;

public class Order {
    private Integer order_id;
    private Date order_date;
    private String customer_name;
    private String ship_address;
    private String notes;
    private Float tax;
    private List<OrderDetails> orderDetailsList;

    public Order(Integer order_id, Date order_date, String customer_name, String ship_address, String notes, Float tax,
            List<OrderDetails> orderDetailsList) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.customer_name = customer_name;
        this.ship_address = ship_address;
        this.notes = notes;
        this.tax = tax;
        this.orderDetailsList = orderDetailsList;
    }
    public Order() {
    }
    public Integer getOrder_id() {
        return order_id;
    }
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    public Date getOrder_date() {
        return order_date;
    }
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public String getShip_address() {
        return ship_address;
    }
    public void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Float getTax() {
        return tax;
    }
    public void setTax(Float tax) {
        this.tax = tax;
    }
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }
    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    
}
