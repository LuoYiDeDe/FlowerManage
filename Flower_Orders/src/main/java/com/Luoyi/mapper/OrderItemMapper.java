package com.Luoyi.mapper;

import com.Luoyi.bean.OrderItems;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderItemMapper {

    @Insert("INSERT INTO order_items(order_id, product_id, quantity, price) " +
            "VALUES(#{orderId}, #{productId}, #{quantity}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(OrderItems orderItem);

    @Delete("DELETE FROM order_items WHERE id = #{id}")
    int deleteById(Integer id);

    @Update("UPDATE order_items SET " +
            "order_id = #{orderId}, product_id = #{productId}, " +
            "quantity = #{quantity}, price = #{price} " +
            "WHERE id = #{id}")
    int update(OrderItems orderItem);

    @Select("SELECT * FROM order_items WHERE id = #{id}")
    OrderItems selectById(Integer id);

    @Select("SELECT * FROM order_items WHERE order_id = #{orderId}")
    List<OrderItems> selectByOrderId(Integer orderId);
}