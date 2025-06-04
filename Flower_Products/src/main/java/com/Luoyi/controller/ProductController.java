package com.Luoyi.controller;

import com.Luoyi.bean.PageReuslt;
import com.Luoyi.bean.Products;
import com.Luoyi.bean.Result;
import com.Luoyi.server.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
     * @Description: 分页获取所有花束
     * @param
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 16:42
     */
    @RequestMapping("/getall")
    public Result getAll(@RequestParam(defaultValue = "1") Integer pageNum,
                         @RequestParam(defaultValue = "16") Integer pageSize){
        PageReuslt<Products> allProducts = productService.getAllProducts(pageNum, pageSize);
        return Result.success(allProducts);
    }
    /*
     * @Description: 根据id获取
     * @param id
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 16:42
     */
    @RequestMapping("/getflower")
    public Result getFlower(Integer id){
        return Result.success(productService.queryProductById(id));
    }
    /*
     * @Description: 修改花束
     * @param products
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 16:42
     */
    @RequestMapping("/updateflower")
    public Result updateFlower(@RequestBody Products products){
        productService.updateProduct(products);
        return Result.success();
    }
    /*
     * @Description: 添加花束
     * @param products
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 18:59
     */
    @RequestMapping("/addflower")
    public Result addFlower(@RequestBody Products products){
        productService.addProduct(products);
        return Result.success();
    }
    /*
     * @Description: 删除花束
     * @param id
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/28 19:00
     */
    @RequestMapping("/delflower")
    public Result delFlower(Integer id){
        productService.delProduct(id);
        return Result.success();
    }


}
