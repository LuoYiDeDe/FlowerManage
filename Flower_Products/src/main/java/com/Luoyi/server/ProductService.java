package com.Luoyi.server;

import com.Luoyi.bean.PageReuslt;
import com.Luoyi.bean.Products;

public interface ProductService {

    public PageReuslt<Products> getAllProducts(Integer pageNum, Integer pageSize);

    public Products queryProductById(Integer id);

    public int updateProduct(Products products);

    public void addProduct(Products products);

    public void delProduct(Integer id);
}
