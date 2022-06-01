package com.livegoods.buyaction.message.consumer.dao;

import com.bjsxt.livegoods.pojo.Order;

// 订单数据访问接口
public interface OrderDao {
    void save(Order order);
}
