package com.livegoods.buytime.service.impl;

import com.bjsxt.livegoods.pojo.Item;
import com.livegoods.buytime.dao.ItemDao;
import com.livegoods.buytime.service.BuytimeService;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询商品预订倒计时， 服务实现
 */
@Service
public class BuytimeServiceImpl implements BuytimeService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public LivegoodsResult getBuytimeById(String id) {
        Item item = this.itemDao.findById(id);
        LivegoodsResult result = LivegoodsResult.ok();
        // 获取商品预订时间的时间戳。
        result.setTime(item.getBuytime().getTime());
        return result;
    }
}
