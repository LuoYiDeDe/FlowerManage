package com.Luoyi.controller;

import com.Luoyi.bean.PointsProducts;
import com.Luoyi.bean.Result;
import com.Luoyi.server.PointsProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/point")
public class PointsProductsController {
    @Autowired
    private PointsProductsService productsService;
    /*
     * @Description: 获取所有积分商品
     * @param
     * @return com.Luoyi.bean.Result<java.util.List<com.Luoyi.bean.PointsProducts>>
     * @Author: 落一.
     * @Date: 2025/5/31 9:26
     */
    @RequestMapping("/allpointsproducts")
    public Result<List<PointsProducts>> getAllPointsProducts(){
        return Result.success(productsService.selectAll());
    }
    /*
     * @Description: 新增商品
     * @param products
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/31 9:28
     */
    @RequestMapping("/addpointsproducts")
    public Result addPointsProduct(@RequestBody PointsProducts products){
        if (productsService.addPointsProducts(products) > 0){
            return Result.success();
        }else {
            return Result.fail("添加失败");
        }
    }
    /*
     * @Description: 修改商品
     * @param products
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/31 9:28
     */
    @RequestMapping("/updatepointsproducts")
    public Result updatePointsProduct(@RequestBody PointsProducts products){
        if (productsService.updatePorintsProducts(products) > 0){
            return Result.success();
        }else {
            return Result.fail("修改失败");
        }
    }

}
