package com.Luoyi.server.impl;


import com.Luoyi.bean.PointsProducts;
import com.Luoyi.bean.dto.UserPointsDTO;
import com.Luoyi.server.PointsProductsService;
import com.Luoyi.server.UserPointsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    private UserPointsService userPointsService;
    @Autowired
    private PointsProductsService productsService;
    /*
     * @Description: 扣减库存
     * @param
     * @return void
     * @Author: 落一.
     * @Date: 2025/6/1 20:06
     */
    @RabbitListener(queues = "reducespointQueue")
    public void reduce(PointsProducts products){
        productsService.updatePorintsProducts(products);
    }
    /*
     * @Description: 扣减用户积分
     * @param userPointsDTO
     * @return void
     * @Author: 落一.
     * @Date: 2025/6/1 20:10
     */
    @RabbitListener(queues = "pointsQueue")
    public void pointsQueue(UserPointsDTO userPointsDTO){
        userPointsService.updatePoints(userPointsDTO);
    }

}
