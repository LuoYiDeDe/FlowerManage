package com.Luoyi.server.impl;

import com.Luoyi.bean.PointsProducts;
import com.Luoyi.bean.dto.PointsExchangeDTO;
import com.Luoyi.bean.dto.UserPointsDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void reducesPoints(PointsExchangeDTO pointsExchangeDTO){
        //设置商品新库存
        PointsProducts pointsProducts = new PointsProducts();
        pointsProducts.setStock(pointsExchangeDTO.getStock() - 1);
        pointsProducts.setId(pointsExchangeDTO.getId());
        //设置用户
        UserPointsDTO userPointsDTO = new UserPointsDTO();
        userPointsDTO.setUserId(pointsExchangeDTO.getUserId());
        userPointsDTO.setAvailablePoints(pointsExchangeDTO.getAvailablePoints());
        userPointsDTO.setPoints(pointsExchangeDTO.getPoints());
        //扣减积分商品库存
        rabbitTemplate.convertAndSend("reducespointExchange","",pointsProducts);
        //扣减用户积分
        rabbitTemplate.convertAndSend("pointsExchange","",userPointsDTO);
    }

}
