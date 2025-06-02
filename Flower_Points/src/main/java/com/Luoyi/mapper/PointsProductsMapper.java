package com.Luoyi.mapper;

import com.Luoyi.bean.PointsProducts;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PointsProductsMapper {

    @Insert("INSERT INTO points_products(name, description, points_required, stock, category, image_url, status) " +
            "VALUES(#{name}, #{description}, #{pointsRequired}, #{stock}, #{category}, #{imageUrl}, #{status})")
    int insert(PointsProducts product);

    @Delete("DELETE FROM points_products WHERE id = #{id}")
    int deleteById(int id);


    int update(PointsProducts product);

    @Select("SELECT * FROM points_products WHERE id = #{id}")
    PointsProducts selectById(int id);

    @Select("SELECT * FROM points_products")
    List<PointsProducts> selectAll();

    @Select("SELECT * FROM points_products WHERE category = #{category}")
    List<PointsProducts> selectByCategory(String category);

    @Update("UPDATE points_products SET stock = #{stock} WHERE id = #{id}")
    int updateStock(@Param("id") int id, @Param("stock") int stock);

    @Update("UPDATE points_products SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") int id, @Param("status") int status);

}