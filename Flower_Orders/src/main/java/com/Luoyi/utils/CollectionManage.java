package com.Luoyi.utils;

import com.Luoyi.bean.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionManage {
    private static List<Map<Integer, List<Products>>>  collectionlist = null;
    /*
     * @Description: 单例
     * @param
     * @return java.util.List<java.util.Map<java.lang.Integer,java.util.List<com.Luoyi.bean.Products>>>
     * @Author: 落一.
     * @Date: 2025/5/26 19:34
     */
    private static List<Map<Integer, List<Products>>> Singleton(){
        if (collectionlist == null){
            collectionlist = new ArrayList<>();
        }
        return collectionlist;
    }
    /*
     * @Description: 获取用户收藏
     * @param userid
     * @return java.util.Map<java.lang.Integer,java.util.List<com.Luoyi.bean.Products>>
     * @Author: 落一.
     * @Date: 2025/5/26 14:58
     */
    public static List<Products> getCollection(Integer userid) {
        List<Products> productsList = new ArrayList<>();
        List<Map<Integer, List<Products>>> singleton = Singleton();
        if (singleton.size() == 0){
            //没有该用户时
            //创建用户存储空间
            Map<Integer,List<Products> > productsMap = new HashMap<>();
            productsMap.put(userid,productsList);
            //加入到内存
            singleton.add(productsMap);
        }else {
            //循环用户列表
            for (Map<Integer, List<Products>> map : Singleton()) {
                List<Products> productsList1 = map.get(userid);
                if (productsList1 != null){
                    productsList = productsList1;

                }
            }
        }
        return productsList;
    }

    /*
     * @Description: 添加收藏
     * @param products
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/26 14:34
     */
    public static void addCollection(Integer userid,Products products){
        List<Products> productsList = new ArrayList<>();
        List<Map<Integer, List<Products>>> singleton = Singleton();
        if (singleton.size() == 0){
            //没有该用户时
            productsList.add(products);
            //创建用户存储空间
            Map<Integer,List<Products> > productsMap = new HashMap<>();
            productsMap.put(userid,productsList);
            //加入到内存
            singleton.add(productsMap);
        }else {
            //循环用户列表
            for (Map<Integer, List<Products>> map : Singleton()) {
                List<Products> productsList1 = map.get(userid);
                if (productsList1 != null){
                    productsList = productsList1;
                    //添加商品进入列表
                    productsList.add(products);
                }
            }
        }

    }
    /*
     * @Description: 移除收藏
     * @param key
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/26 14:34
     */
    public static void delCollection(Integer userid,Products products){
        //循环用户列表
        for (Map<Integer, List<Products>> map : Singleton()) {
            List<Products> productsList1 = map.get(userid);
            productsList1.remove(products);
        }
    }
    /*
     * @Description: 清空收藏
     * @param
     * @return void
     * @Author: 落一.
     * @Date: 2025/5/26 14:35
     */
    public static void clearAllCollection(Integer userid){
        //循环用户列表
        for (Map<Integer, List<Products>> map : Singleton()) {
            List<Products> productsList = map.get(userid);
            productsList.clear();
        }

    }
}
