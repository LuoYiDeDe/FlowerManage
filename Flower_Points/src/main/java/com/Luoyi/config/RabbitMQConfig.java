package com.Luoyi.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue reducespointQueue(){//积分商品库存扣减队列
        return new Queue("reducespointQueue");
    }
    @Bean
    public Queue pointsQueue(){//积分扣减队列
        return new Queue("pointsQueue");
    }

    @Bean
    public FanoutExchange reducespointExchange(){//积分商品库存扣减交换机
        return new FanoutExchange("reducespointExchange");
    }
    @Bean
    public FanoutExchange pointsExchange(){//积分扣减交换机
        return new FanoutExchange("pointsExchange");
    }

    @Bean
    public Binding bindReduce(){
        return BindingBuilder.bind(reducespointQueue()).to(reducespointExchange());
    }
    @Bean
    public Binding bindItem(){
        return BindingBuilder.bind(pointsQueue()).to(pointsExchange());
    }




}
