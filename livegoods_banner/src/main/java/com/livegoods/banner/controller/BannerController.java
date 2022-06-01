package com.livegoods.banner.controller;

import com.livegoods.banner.service.BannerService;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * 处理轮播图查询的方法。
     * 轮播图数量？ 理论上是无穷多的。
     * 什么样的轮播图信息是优先显示的？
     * 根据创建时间的降序排列，查询前6个轮播图数据
     *
     * 返回结果是一个有格式的字符串。 就是JSON
     * @return
     *  查询成功 - {"status":数学类型|响应状态 200, "results":["图片地址","",""]}
     *  查询失败 - {"status":数学类型|响应状态 500, "msg":"错误提示消息"}
     */
    @GetMapping("/banner")
    public LivegoodsResult banner(){
        return bannerService.getBanners();
    }
}
