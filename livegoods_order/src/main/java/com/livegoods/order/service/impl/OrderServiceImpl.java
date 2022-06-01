package com.livegoods.order.service.impl;

import com.bjsxt.livegoods.pojo.Order;
import com.livegoods.order.dao.OrderDao;
import com.livegoods.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 订单服务实现
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getOrders(String user) {
        return orderDao.getOrders(user);
    }
}
