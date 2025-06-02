package com.Luoyi.server;


import com.Luoyi.bean.OrderItems;
import com.Luoyi.bean.Orders;
import com.Luoyi.bean.vo.ManageOrderVO;

import java.util.List;
//订单相关方法
public interface OrderService {

    void createOrder(Orders orders);

    void createOrderItem(OrderItems orderItems);

    List<Orders> getOrdersByUserId(Integer userId);

    List<OrderItems> getOrderItems(Integer orederId);

    ManageOrderVO getAllOrdersToday();

    List<Orders> getAllOrders();

    void shipmentsProduct(Integer id);


}
