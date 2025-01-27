package com.ws24.ws24.Model;

public class OrderDetails {
    private String id;
    private String product;
    private Float unit_price;
    private Float discount;
    private Integer quantity;
    private Integer order_id;

    public OrderDetails(String id, String product, Float unit_price, Float discount, Integer quantity,
            Integer order_id) {
        this.id = id;
        this.product = product;
        this.unit_price = unit_price;
        this.discount = discount;
        this.quantity = quantity;
        this.order_id = order_id;
    }
    public OrderDetails() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public Float getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
    }
    public Float getDiscount() {
        return discount;
    }
    public void setDiscount(Float discount) {
        this.discount = discount;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getOrder_id() {
        return order_id;
    }
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    
}
