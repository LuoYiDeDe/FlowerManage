package com.Luoyi.mapper;


import com.Luoyi.bean.PointsExchange;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PointsExchangeMapper {

    @Insert("INSERT INTO points_exchange(user_id, product_id, exchange_points, status, tracking_number,exchange_time) " +
            "VALUES(#{userId}, #{productId}, #{exchangePoints}, 0, #{trackingNumber} , now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(PointsExchange pointsExchange);

    @Delete("DELETE FROM points_exchange WHERE id = #{id}")
    int deleteById(Integer id);

    @Update("UPDATE points_exchange SET status = #{status} where id = #{id}")
    int update(PointsExchange pointsExchange);

    @Select("SELECT * FROM points_exchange WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "exchangePoints", column = "exchange_points"),
            @Result(property = "exchangeTime", column = "exchange_time"),
            @Result(property = "status", column = "status"),
            @Result(property = "trackingNumber", column = "tracking_number")
    })
    PointsExchange selectById(Integer id);

    @Select("SELECT * FROM points_exchange")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "exchangePoints", column = "exchange_points"),
            @Result(property = "exchangeTime", column = "exchange_time"),
            @Result(property = "status", column = "status"),
            @Result(property = "trackingNumber", column = "tracking_number")
    })
    List<PointsExchange> selectAll();

    @Select("SELECT * FROM points_exchange WHERE user_id = #{userId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "exchangePoints", column = "exchange_points"),
            @Result(property = "exchangeTime", column = "exchange_time"),
            @Result(property = "status", column = "status"),
            @Result(property = "trackingNumber", column = "tracking_number")
    })
    List<PointsExchange> selectByUserId(Integer userId);
}