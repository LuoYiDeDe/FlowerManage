package com.Luoyi.mapper;

import com.Luoyi.bean.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    void insert(Orders order);

    @Delete("DELETE FROM orders WHERE id = #{id}")
    int deleteById(Long id);

    @Update("UPDATE orders SET " +
            "user_id = #{userId}, " +
            "order_no = #{orderNo}, " +
            "total_amount = #{totalAmount}, " +
            "pay_status = #{payStatus}, " +
            "order_status = #{orderStatus}, " +
            "address = #{address}, " +
            "pay_time = #{payTime} " +
            "WHERE id = #{id}")
    int update(Orders order);

    @Update("update orders set order_status = 1 where id = #{id}")
    int updateOrderStatus(Integer id);

    @Select("SELECT * FROM orders WHERE user_id = #{userId}")
    List<Orders> selectByUserId(Integer userId);

    @Select("SELECT * FROM orders WHERE order_no = #{orderNo}")
    Orders selectByOrderNo(String orderNo);

    @Select("SELECT * FROM orders")
    List<Orders> selectAll();
    //今日订单数量
    List<Orders>  getAllOrdersToday();
}