package com.ws24.ws24.Model;

public class Order {
    private String order_id;
    private String order_date;
    private String customer_name;
    private String ship_address;
    private String notes;
    private String tax;

    public Order(String order_id, String order_date, String customer_name, String ship_address, String notes,
            String tax) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.customer_name = customer_name;
        this.ship_address = ship_address;
        this.notes = notes;
        this.tax = tax;
    }
    public Order() {
    }
    public String getOrder_id() {
        return order_id;
    }
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    public String getOrder_date() {
        return order_date;
    }
    public void setOrder_date(String order_date) {
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
    public String getTax() {
        return tax;
    }
    public void setTax(String tax) {
        this.tax = tax;
    }

    

    
}
