package com.Luoyi.server.impl;

import com.Luoyi.bean.OrderItems;
import com.Luoyi.bean.Orders;
import com.Luoyi.bean.PageReuslt;
import com.Luoyi.bean.vo.ManageOrderVO;
import com.Luoyi.client.ProductFeignClient;
import com.Luoyi.mapper.OrderItemMapper;
import com.Luoyi.mapper.OrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Luoyi.server.OrderService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductFeignClient productFeignClient;
    /*
     * @Description: 创建订单
     * @param orders
     * @return java.lang.Integer
     * @Author: 落一.
     * @Date: 2025/5/23 10:22
     */
    @Override
    public void createOrder(Orders orders) {
        orderMapper.insert(orders);
    }
    /*
     * @Description: 创建订单明细
     * @param orderItems
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/23 10:22
     */
    @Override
    public void createOrderItem(OrderItems orderItems) {
        orderItemMapper.insert(orderItems);
    }
    /*
     * @Description: 查询用户订单
     * @param userId
     * @return java.util.List<com.Luoyi.bean.Orders>
     * @Author: 落一.
     * @Date: 2025/5/23 10:22
     */
    @Override
    public PageReuslt<Orders> getOrdersByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //获取用户订单列表
        List<Orders> ordersList = orderMapper.selectByUserId(userId);
        //获取分页信息
        PageInfo<Orders> ordersPageInfo = new PageInfo<>(ordersList);
        //封装结果
        PageReuslt<Orders> pageReuslt = new PageReuslt<>();
        pageReuslt.setList(ordersList);
        pageReuslt.setPageNum(ordersPageInfo.getPageNum());
        pageReuslt.setPageSize(ordersPageInfo.getPageSize());
        pageReuslt.setTotal(ordersPageInfo.getTotal());
        pageReuslt.setPages(ordersPageInfo.getPages());
        //返回
        return pageReuslt;
    }
    /*
     * @Description: 获取订单明细
     * @param orederId
     * @return java.util.List<com.Luoyi.bean.OrderItems>
     * @Author: 落一.
     * @Date: 2025/5/23 10:22
     */
    public List<OrderItems> getOrderItems(Integer orederId){
         return orderItemMapper.selectByOrderId(orederId);
    }

    @Override
    public ManageOrderVO getAllOrdersToday() {
        List<Orders> allOrdersToday = orderMapper.getAllOrdersToday();
        BigDecimal totalprice = new BigDecimal(0);
        for (Orders orders : allOrdersToday) {
            BigDecimal totalAmount = orders.getTotalAmount();
            totalprice = totalprice.add(totalAmount);
        }
        return new ManageOrderVO(allOrdersToday.size(), totalprice.doubleValue());
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderMapper.selectAll();
    }

    @Override
    public void shipmentsProduct(Integer id) {
        orderMapper.updateOrderStatus(id);
    }

}
