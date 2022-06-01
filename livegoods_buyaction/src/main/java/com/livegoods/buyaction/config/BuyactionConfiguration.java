package com.livegoods.buyaction.config;

import com.livegoods.cache.config.RedisCacheConfiguration;
import com.livegoods.message.publisher.LivegoodsMessagePublisher;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class BuyactionConfiguration extends RedisCacheConfiguration {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        return super.redisTemplate(redisConnectionFactory);
    }
    @Bean
    public LivegoodsMessagePublisher livegoodsMessagePublisher(AmqpTemplate amqpTemplate){
        LivegoodsMessagePublisher messagePublisher = new LivegoodsMessagePublisher();
        messagePublisher.setAmqpTemplate(amqpTemplate);
        return messagePublisher;
    }
}
