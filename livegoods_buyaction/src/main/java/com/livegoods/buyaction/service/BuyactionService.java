package com.livegoods.buyaction.service;

import com.livegoods.commons.vo.LivegoodsResult;

// 购买服务接口
public interface BuyactionService {
    /**
     * 购买商品服务方法
     * @param id 商品主键
     * @param user 用户手机号
     * @return 购买是否成功
     */
    LivegoodsResult buyaction(String id, String user);
}
