package com.livegoods.order.service;

import com.bjsxt.livegoods.pojo.Order;

import java.util.List;

// 订单服务接口
public interface OrderService {
    // 查询用户的订单集合。
    List<Order> getOrders(String user);
}
