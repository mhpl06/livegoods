package com.livegoods.buytime.service;

import com.livegoods.commons.vo.LivegoodsResult;

// 查询商品预订倒计时服务接口
public interface BuytimeService {
    // 根据商品主键，查询预订倒计时
    LivegoodsResult getBuytimeById(String id);
}
