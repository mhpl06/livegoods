package com.livegoods.buytime.controller;

import com.livegoods.buytime.service.BuytimeService;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 查询商品预订倒计时控制器。
 */
@RestController
@CrossOrigin
public class BuytimeController {
    @Autowired
    private BuytimeService buytimeService;

    /**
     * 根据商品主键，查询商品预订时间。
     * @param id 商品主键
     * @return
     */
    @GetMapping("/buytime")
    public LivegoodsResult getBuytime(String id){
        return buytimeService.getBuytimeById(id);
    }
}
