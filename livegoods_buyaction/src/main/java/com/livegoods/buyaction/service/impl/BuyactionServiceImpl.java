package com.livegoods.buyaction.service.impl;

import com.bjsxt.livegoods.pojo.Item;
import com.livegoods.buyaction.redisdao.ItemDao;
import com.livegoods.buyaction.service.BuyactionService;
import com.livegoods.commons.message.LivegoodsBuyMessage;
import com.livegoods.commons.vo.LivegoodsResult;
import com.livegoods.message.publisher.LivegoodsMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// 购买商品服务实现
@Service
public class BuyactionServiceImpl implements BuyactionService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private LivegoodsMessagePublisher messagePublisher;
    @Value("${livegoods.cache.names.item.prefix}")
    private String itemPrefix;
    @Value("${livegoods.cache.names.item.suffix}")
    private String itemSuffix;
    @Value("${livegoods.rabbit.buy.exchange}")
    private String exchange;
    @Value("${livegoods.rabbit.buy.routingKey}")
    private String routingKey;

    /**
     * 实现流程：
     *  1、 访问redis，查询这个商品是否可购买
     *  2、 封装一个消息对象，发送消息到MQ，并等待消费者的响应
     *  3、 根据消息消费者响应结果，返回操作结果
     * @param id 商品主键
     * @param user 用户手机号
     * @return
     */
    @Override
    public LivegoodsResult buyaction(String id, String user) {
        String key = itemPrefix + "::" + itemSuffix + "(" + id + ")";
        Item item = this.itemDao.get(key);
        if(item.getIsRented()){
            // 房屋已出租。不能再次预定。直接返回。
            LivegoodsResult result = LivegoodsResult.error();
            result.setMsg("手慢了，已经被抢订，预订失败！");
            return result;
        }
        // 创建消息对象
        LivegoodsBuyMessage message = new LivegoodsBuyMessage();
        message.setItemId(id);
        message.setUsername(user);
        // 发送消息
        Boolean messageResult =
                (Boolean) messagePublisher.sendMessageSync(exchange, routingKey, message);

        if(messageResult){
            // 购买成功
            LivegoodsResult result = LivegoodsResult.ok();
            result.setMsg("预定成功！");
            return result;
        }else{
            // 购买失败
            LivegoodsResult result = LivegoodsResult.error();
            result.setMsg("手慢了，已经被抢订，预订失败！");
            return result;
        }
    }
}
