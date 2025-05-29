package com.Luoyi.mapper;

import com.Luoyi.bean.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("select * from products")
    List<Products> getAllProducts();

    @Select("select * from products where id = #{id}")
    Products queryProductById(Integer id);

    @Insert("insert into products (name, description, price, stock, category, image_url, status, created_at) " +
            "values (#{name},#{description},#{price},#{stock},#{category},#{imageUrl},#{status},now())")
    int addProduct(Products products);


    int updateProduct(Products products);

    @Delete("delete from products where id=#{id}")
    int deleteProductById(Integer id);
}