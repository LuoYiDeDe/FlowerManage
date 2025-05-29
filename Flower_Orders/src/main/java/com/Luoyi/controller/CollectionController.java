package com.Luoyi.controller;

import com.Luoyi.bean.Result;
import com.Luoyi.bean.dto.CollectionDTO;
import org.springframework.web.bind.annotation.*;

import static com.Luoyi.utils.CollectionManage.*;

@RestController
@RequestMapping("/like")
public class CollectionController { //收藏

    /*
     * @Description: 获取用户收藏
     * @param userid
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/26 15:00
     */
    @GetMapping("/getcollection")
    public Result get(Integer userid){
        return Result.success(getCollection(userid));
    }
    /*
     * @Description: 添加收藏
     * @param userid
     * @param products
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/26 14:48
     */
    @PostMapping("/addcollection")
    public Result add(@RequestBody CollectionDTO collectionDTO){
        addCollection(collectionDTO.getUserid(),collectionDTO.getProducts());
        return Result.success();
    }
    /*
     * @Description: 删除收藏
     * @param userid
     * @param products
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/26 14:48
     */
    @PostMapping("/delcollection")
    public Result del(@RequestBody CollectionDTO collectionDTO){
        delCollection(collectionDTO.getUserid(),collectionDTO.getProducts());
        return Result.success();
    }
    /*
     * @Description: 清空收藏
     * @param userid
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/5/26 14:49
     */
    @GetMapping("/clearall")
    public Result clearAll(Integer userid){
        clearAllCollection(userid);
        return Result.success();
    }

}
