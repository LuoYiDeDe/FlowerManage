package com.Luoyi.client;

import com.Luoyi.bean.Products;
import com.Luoyi.bean.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MyProductService")
public interface ProductFeignClient {

    @RequestMapping("/product/getflower")
    Result<Products> getflower(@RequestParam("id") Integer id);

    @PostMapping("/product/updateflower")
    Result updateflower(@RequestBody Products products);

}
