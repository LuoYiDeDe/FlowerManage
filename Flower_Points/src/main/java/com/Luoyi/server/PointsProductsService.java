package com.Luoyi.server;

import com.Luoyi.bean.PointsProducts;

import java.util.List;

public interface PointsProductsService {

    List<PointsProducts> selectAll();

    int addPointsProducts(PointsProducts products);

    int updatePorintsProducts(PointsProducts products);

    PointsProducts selectById(Integer id);

}
