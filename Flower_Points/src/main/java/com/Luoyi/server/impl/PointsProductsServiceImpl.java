package com.Luoyi.server.impl;

import com.Luoyi.bean.PointsProducts;
import com.Luoyi.mapper.PointsProductsMapper;
import com.Luoyi.server.PointsProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointsProductsServiceImpl implements PointsProductsService {

    @Autowired
    private PointsProductsMapper pointsProductsMapper;
    /*
     * @Description: 查询所有积分商品
     * @param
     * @return java.util.List<com.Luoyi.bean.PointsProducts>
     * @Author: 落一.
     * @Date: 2025/5/31 9:20
     */
    @Override
    public List<PointsProducts> selectAll() {
        return pointsProductsMapper.selectAll();
    }
    /*
     * @Description: 新增积分商品
     * @param products
     * @return int
     * @Author: 落一.
     * @Date: 2025/5/31 9:20
     */
    @Override
    public int addPointsProducts(PointsProducts products) {
        return pointsProductsMapper.insert(products);
    }
    /*
     * @Description: 修改积分商品
     * @param products
     * @return int
     * @Author: 落一.
     * @Date: 2025/5/31 9:21
     */
    @Override
    public int updatePorintsProducts(PointsProducts products) {
        return pointsProductsMapper.update(products);
    }
    /*
     * @Description: 根据id查询商品
     * @param id
     * @return com.Luoyi.bean.PointsProducts
     * @Author: 落一.
     * @Date: 2025/6/2 9:25
     */
    @Override
    public PointsProducts selectById(Integer id) {
        return pointsProductsMapper.selectById(id);
    }
}
