package com.Luoyi.server;

import com.Luoyi.bean.Products;

import java.util.List;

public interface ProductService {

    public List<Products> getAllProducts();

    public Products queryProductById(Integer id);

    public int updateProduct(Products products);

    public void addProduct(Products products);

    public void delProduct(Integer id);
}
