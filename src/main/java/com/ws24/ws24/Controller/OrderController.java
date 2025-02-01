package com.ws24.ws24.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ws24.ws24.Model.Order;
import com.ws24.ws24.Model.OrderDetails;
import com.ws24.ws24.Service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("")
    public ModelAndView orderForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("dsForm");
        Order order = new Order();
        OrderDetails orderDetails = new OrderDetails();
        mav.addObject("order",order);
        mav.addObject("orderDetails",orderDetails);
        return mav;
    }
    @PostMapping("")
    public ModelAndView postMethodName(@ModelAttribute Order order) {
        ModelAndView mav = new ModelAndView("results");
        String results = "Successfully added!";
        try {
            orderService.addOrder(order);
        } catch (Exception e) {
            results = "Something went wrong..\n" +e.getMessage();
        }
        mav.addObject("results",results);
        return mav;
    }
}
