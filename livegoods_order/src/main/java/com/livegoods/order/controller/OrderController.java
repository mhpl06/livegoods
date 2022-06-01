package com.livegoods.order.controller;

import com.bjsxt.livegoods.pojo.Order;
import com.livegoods.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 订单控制器
@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    // 查询用户的订单集合
    @GetMapping("/order")
    public List<Order> getOrders(String user){
        return orderService.getOrders(user);
    }
}
