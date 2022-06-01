package com.livegoods.buytime.dao.impl;

import com.bjsxt.livegoods.pojo.Item;
import com.livegoods.buytime.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 查询商品预订倒计时，数据访问实现
 */
@Repository
public class ItemDaoImpl implements ItemDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Item findById(String id) {
        return mongoTemplate.findById(id, Item.class);
    }
}
