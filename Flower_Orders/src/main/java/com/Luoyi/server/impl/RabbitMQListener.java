package com.Luoyi.server.impl;

import com.Luoyi.bean.OrderItems;
import com.Luoyi.bean.Products;
import com.Luoyi.bean.Result;
import com.Luoyi.client.CouponsFeignClient;
import com.Luoyi.client.ProductFeignClient;
import com.Luoyi.server.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductFeignClient productFeignClient;
    @Autowired
    private CouponsFeignClient couponsFeignClient;

    /*
     * @Description: 扣减库存
     * @param orderItems
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/24 17:12
     */
    @RabbitListener(queues = "reducesQueue")
    public void reduce(OrderItems orderItems){
        Result<Products> getflower = productFeignClient.getflower(orderItems.getProductId());
        Products flowerData = getflower.getData();
        flowerData.setStock(flowerData.getStock() - orderItems.getQuantity());

        productFeignClient.updateflower(flowerData);
    }

    /*
     * @Description: 创建订单明细
     * @param orderItems
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/24 17:08
     */
    @RabbitListener(queues = "itemQueue")
    public void itemOrder(OrderItems orderItems){
        orderService.createOrderItem(orderItems);
    }
    /*
     * @Description: 使用优惠劵
     * @param id
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/27 20:37
     */
    @RabbitListener(queues = "couponQueue")
    public void usedCoupon(Integer id){
        couponsFeignClient.usedCoupons(id);
    }


}
