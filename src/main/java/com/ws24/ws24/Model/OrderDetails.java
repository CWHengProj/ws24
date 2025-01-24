package com.ws24.ws24.Model;

public class OrderDetails {
    private String id;
    private String product;
    private String unit_price;
    private String discount;
    private String quantity;
    private String order_id;
    
    public OrderDetails() {
    }
    public OrderDetails(String id, String product, String unit_price, String discount, String quantity,
            String order_id) {
        this.id = id;
        this.product = product;
        this.unit_price = unit_price;
        this.discount = discount;
        this.quantity = quantity;
        this.order_id = order_id;
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
    public String getUnit_price() {
        return unit_price;
    }
    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }
    public String getDiscount() {
        return discount;
    }
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getOrder_id() {
        return order_id;
    }
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    

}
