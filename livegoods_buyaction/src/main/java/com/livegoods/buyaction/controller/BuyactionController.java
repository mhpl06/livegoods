package com.livegoods.buyaction.controller;

import com.livegoods.buyaction.service.BuyactionService;
import com.livegoods.commons.vo.LivegoodsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 购买控制器
@RestController
@CrossOrigin
public class BuyactionController {
    @Autowired
    private BuyactionService buyactionService;

    /**
     * 预定房屋
     * @param id 商品主键
     * @param user 登录用户手机号
     * @return 预定结果
     */
    @GetMapping("/buyaction")
    public LivegoodsResult buyaction(String id, String user){
        return buyactionService.buyaction(id, user);
    }
}
