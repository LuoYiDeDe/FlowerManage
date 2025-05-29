package com.Luoyi.controller;

import com.Luoyi.bean.*;
import com.Luoyi.bean.dto.OrderDTO;
import com.Luoyi.bean.vo.ManageOrderVO;
import com.Luoyi.bean.vo.OrderVO;
import com.Luoyi.client.ProductFeignClient;
import com.Luoyi.server.OrderService;
import com.Luoyi.server.impl.RabbitPublisher;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductFeignClient productFeignClient;
    @Autowired
    private RabbitPublisher rabbitPublisher;
    /*
     * @Description: 生成订单 订单明细
     * @param orderDTO
     * @return bean.Result
     * @Author: 落一.
     * @Date: 2025/5/22 20:24
     */
    @RequestMapping("/create")
    public Result createOrder(@RequestBody OrderDTO orderDTO){
        Orders orders = new Orders();
        OrderItems orderItems = new OrderItems();
        //设置值
        BeanUtils.copyProperties(orderDTO,orders);
        BeanUtils.copyProperties(orderDTO,orderItems);
        //生成订单编号
        String uuid =UUID.randomUUID().toString().replace("-","");
        //设置订单编号，已支付，代发货
        orders.setOrderNo(uuid);
        orders.setPayStatus(1);
        orders.setOrderStatus(0);
        //返回订单id
        orderService.createOrder(orders);
        Integer orderid = orders.getId();
        //创建失败
        if (orderid == null || orderid == 0){
            return Result.fail("订单生成失败，请重试");
        }
        //创建订单明细
        orderItems.setOrderId(orderid);
        //通过RabbitMQ异步完成
        //扣减库存 创建订单明细 使用优惠劵
        rabbitPublisher.payOrder(orderItems,orderDTO.getCouponId());

        return Result.success();
    }
    /*
     * @Description: 获取用户订单
     * @param userId
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/23 10:24
     */
    @RequestMapping("/getorders")
    public Result getOrders(Integer userId){
        List<Orders> orders = orderService.getOrdersByUserId(userId);
        List<OrderVO> orderVOList = new ArrayList<>();

        for (Orders order : orders) {
            OrderVO orderVO = new OrderVO();
            //设置vo信息
            Integer id = order.getId();
            orderVO.setId(id);
            orderVO.setTotalAmount(order.getTotalAmount());
            orderVO.setOrderNo(order.getOrderNo());
            orderVO.setOrderStatus(order.getOrderStatus());
            orderVO.setCreatedAt(order.getCreatedAt());

            List<OrderItems> orderItems = orderService.getOrderItems(id);
            for (OrderItems orderItem : orderItems) {
                Integer productId = orderItem.getProductId();
                //调用商品服务获取信息
                Result flower =  productFeignClient.getflower(productId);
                Products data = (Products) flower.getData();
                orderVO.setOrderName(data.getName());
                orderVO.setImage(data.getImageUrl());
                orderVO.setQuantity(orderItem.getQuantity());
            }
            //存入数组
            orderVOList.add(orderVO);
        }

        return Result.success(orderVOList);
    }
    /*
     * @Description: 获取当日营销总额 和 订单总数
     * @param
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 16:33
     */
    @RequestMapping("/getallordersmes")
    public Result getAllMes(){
        ManageOrderVO allOrdersToday = orderService.getAllOrdersToday();
        return Result.success(allOrdersToday);
    }
    /*
     * @Description: 获取全部订单
     * @param
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 19:07
     */
    @RequestMapping("/getallorders")
    public Result getAllOrders(){
        List<Orders> allOrders = orderService.getAllOrders();
        return Result.success(allOrders);
    }
    /*
     * @Description: 修改订单状态
     * @param id
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 19:11
     */
    @RequestMapping("/shipments")
    public Result shipmentsProduct(Integer id){
        orderService.shipmentsProduct(id);
        return Result.success();
    }

}
