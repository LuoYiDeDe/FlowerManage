package com.Luoyi.server.impl;

import com.Luoyi.bean.PageReuslt;
import com.Luoyi.bean.Products;
import com.Luoyi.mapper.ProductMapper;
import com.Luoyi.server.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    /*
     * @Description: 获取所有商品
     * @param
     * @return java.util.List<com.Luoyi.bean.Products>
     * @Author: 落一.
     * @Date: 2025/5/24 16:42
     */
    @Override
    public PageReuslt<Products> getAllProducts(Integer pageNum, Integer pageSize) {
        //打开分页
        PageHelper.startPage(pageNum,pageSize);
        //获取商品
        List<Products> productslist = productMapper.getAllProducts();

        PageInfo<Products> pageInfo = new PageInfo<>(productslist);
        //设置返回类
        PageReuslt<Products> pageReuslt = new PageReuslt<>();
        pageReuslt.setList(productslist);
        pageReuslt.setPageNum(pageInfo.getPageNum());
        pageReuslt.setPageSize(pageInfo.getPageSize());
        pageReuslt.setPages(pageInfo.getPages());
        pageReuslt.setTotal(pageInfo.getTotal());
        return pageReuslt;
    }
    /*
     * @Description: 根据id查询商品
     * @param id
     * @return com.Luoyi.bean.Products
     * @Author: 落一.
     * @Date: 2025/5/24 16:41
     */
    @Override
    public Products queryProductById(Integer id) {
        return productMapper.queryProductById(id);
    }
    /*
     * @Description: 修改商品
     * @param products
     * @return int
     * @Author: 落一.
     * @Date: 2025/5/24 16:42
     */
    @Override
    public int updateProduct(Products products) {
        return productMapper.updateProduct(products);
    }
    /*
     * @Description: 添加商品
     * @param products
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/28 16:52
     */
    @Override
    public void addProduct(Products products) {
        productMapper.addProduct(products);
    }

    @Override
    public void delProduct(Integer id) {
        productMapper.deleteProductById(id);
    }
}
