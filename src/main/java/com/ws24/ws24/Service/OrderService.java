package com.ws24.ws24.Service;

import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws24.ws24.Model.Order;
import com.ws24.ws24.Model.OrderDetails;
import com.ws24.ws24.Repository.OrderDetailsRepo;
import com.ws24.ws24.Repository.OrderRepo;
import com.ws24.ws24.Repository.RedisRepo;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;


@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderDetailsRepo orderDetailsRepo;
    @Autowired
    RedisRepo rRepo;
    @Autowired
    @Qualifier("application")
    RedisTemplate<String,String> redisTemplate;
    @Transactional
    public void addOrder(Order order) throws Exception{
        int orderId = orderRepo.addOrderGetOrderID(order);
        List<OrderDetails> od = order.getOrderDetailsList();
        orderDetailsRepo.addOrderDetails(od,orderId);

    }
    public Order convertFromJsontoOrder(String data) {
        //get the values of Order
        JsonObject jsonObject = Json.createReader(new StringReader(data)).readObject();
        String toWho = jsonObject.getString("toWho");
        LocalDate order_date = LocalDate.parse(jsonObject.getString("order_date"));
        String customer_name = jsonObject.getString("customer_name");
        String ship_address=jsonObject.getString("ship_address");
        String notes = jsonObject.getString("notes");
        Float tax= Float.parseFloat(jsonObject.getString("tax")); //FIXME:
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        //get all the order details from line_items
        JsonArray lineItems = jsonObject.getJsonArray("line_items");
        //instantiate and assign value to order details
        for(int i=0;i<lineItems.size();i++){
            //orderdetailJson is the json format for 1 orderdetail in line items
            JsonObject orderDetailJson = lineItems.getJsonObject(i);
            OrderDetails orderDetail = new OrderDetails();
            orderDetail.setDiscount(Float.parseFloat(orderDetailJson.getString("discount")));
            orderDetail.setProduct(orderDetailJson.getString("product"));
            orderDetail.setQuantity(orderDetailJson.getInt("quantity"));
            orderDetail.setUnit_price(Float.parseFloat(orderDetailJson.getString("unit_price")));
            //add the od to the list in order
            orderDetailsList.add(orderDetail);
        }
        //instantiate order and assign the variables
        Order order = new Order();
        order.setCustomer_name(customer_name);
        order.setNotes(notes);
        order.setOrderDetailsList(orderDetailsList);
        order.setOrder_date(order_date);
        order.setShip_address(ship_address);
        order.setTax(tax);
        order.setToWho(toWho);

        return order;
    }
    public String convertFromOrdertoJson(Order order) {
        //TODO: temporarily remove order id and id see if things work
        //line_items is an array, we need to build it first before adding to the whole json
        JsonArrayBuilder lineItemsArrayBuilder= Json.createArrayBuilder();
        for(OrderDetails oDetail: order.getOrderDetailsList()){
            //create an object and add them to line_items
            JsonObject orderDetailObj = Json.createObjectBuilder()
                                            .add("product",oDetail.getProduct())
                                            .add("unit_price",oDetail.getUnit_price().toString())
                                            .add("discount",oDetail.getDiscount().toString())
                                            .add("quantity",oDetail.getQuantity())
                                            .build();
            lineItemsArrayBuilder.add(orderDetailObj);
        }
        JsonArray line_items =lineItemsArrayBuilder.build();
        //create Json object for order
        JsonObject json = Json.createObjectBuilder()
                            .add("toWho",order.getToWho())
                            .add("order_date",order.getOrder_date().toString())
                            .add("customer_name",order.getCustomer_name())
                            .add("ship_address",order.getShip_address())
                            .add("notes",order.getNotes())
                            .add("tax",order.getTax().toString())
                            .add("line_items",line_items)
                            .build();
        return json.toString();
    }
    public void addToRedis(String toWho,String userOrder) {
        rRepo.addUserOrder(toWho,userOrder);
    }

}
