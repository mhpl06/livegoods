package com.livegoods.order.dao.impl;

import com.bjsxt.livegoods.pojo.Order;
import com.livegoods.order.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// 订单数据访问实现
@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据用户手机号查询订单
     * @param user 用户手机号
     * @return
     */
    @Override
    public List<Order> getOrders(String user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(user));
        return mongoTemplate.find(query, Order.class);
    }
}
