package com.ws24.ws24.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ws24.ws24.Service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("")
    public String OrderForm() {
        //this form is used for user to submit their order information and order details
        return "form";
    }
    @PostMapping("")
    public String postMethodName(@RequestParam MultiValueMap<String, String> data) {
        //insert new order into orders table, return error message if fail
        //new order - insert 1 or more records into orders and order_details table
        return "results";
    }
}
