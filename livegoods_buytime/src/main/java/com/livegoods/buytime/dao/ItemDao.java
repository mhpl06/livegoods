package com.livegoods.buytime.dao;

import com.bjsxt.livegoods.pojo.Item;

// 查询商品预订倒计时，数据访问接口
public interface ItemDao {
    // 根据主键，查询商品
    Item findById(String id);
}
