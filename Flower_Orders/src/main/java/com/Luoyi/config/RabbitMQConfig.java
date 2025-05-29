package com.Luoyi.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue reducesQueue(){//库存扣减队列
        return new Queue("reducesQueue");
    }
    @Bean
    public Queue itemQueue(){//订单详细队列
        return new Queue("itemQueue");
    }
    @Bean
    public Queue couponQueue(){//使用优惠劵
        return new Queue("couponQueue");
    }
    @Bean
    public FanoutExchange reducesExchange(){//减库存交换机
        return new FanoutExchange("reducesExchange");
    }
    @Bean
    public FanoutExchange itemExchange(){//订单详情交换机
        return new FanoutExchange("itemExchange");
    }
    @Bean
    public FanoutExchange couponExchange(){//优惠券交换机
        return new FanoutExchange("couponExchange");
    }
    @Bean
    public Binding bindReduce(){
        return BindingBuilder.bind(reducesQueue()).to(reducesExchange());
    }
    @Bean
    public Binding bindItem(){
        return BindingBuilder.bind(itemQueue()).to(itemExchange());
    }
    @Bean
    public Binding bindCoupon(){
        return BindingBuilder.bind(couponQueue()).to(couponExchange());
    }



}
