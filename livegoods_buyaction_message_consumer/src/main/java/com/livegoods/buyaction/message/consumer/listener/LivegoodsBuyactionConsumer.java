package com.livegoods.buyaction.message.consumer.listener;

import com.livegoods.buyaction.message.consumer.service.BuyactionService;
import com.livegoods.commons.message.LivegoodsBuyMessage;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 购买消息消费者
@Component
public class LivegoodsBuyactionConsumer {
    @Autowired
    private BuyactionService buyactionService;

    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue(name = "${livegoods.rabbit.buy.queue}", autoDelete = "false"),
            exchange = @Exchange(name = "${livegoods.rabbit.buy.exchange}"),
            key = "${livegoods.rabbit.buy.routingKey}"
    )})
    public Object onMessage(LivegoodsBuyMessage message){
        // 商品主键
        String itemId = message.getItemId();
        // 用户手机号
        String user = message.getUsername();

        boolean result = buyactionService.buyaction(itemId, user);

        return result;
    }
}
