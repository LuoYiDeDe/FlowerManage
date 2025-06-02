package com.Luoyi.server.impl;

import com.Luoyi.bean.OrderItems;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void payOrder(OrderItems orderItems,Integer id){
        //扣减库存
        rabbitTemplate.convertAndSend("reducesExchange","",orderItems);
        //生成订单明细
        rabbitTemplate.convertAndSend("itemExchange","",orderItems);
        //使用优惠劵
        rabbitTemplate.convertAndSend("couponExchange","",id);
    }

}
