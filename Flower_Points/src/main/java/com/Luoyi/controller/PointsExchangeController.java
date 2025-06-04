package com.Luoyi.controller;

import com.Luoyi.bean.PointsExchange;
import com.Luoyi.bean.PointsProducts;
import com.Luoyi.bean.Result;
import com.Luoyi.bean.dto.PointsExchangeDTO;
import com.Luoyi.bean.vo.PointsExchangeVO;
import com.Luoyi.server.PointsExchangeService;
import com.Luoyi.server.PointsProductsService;
import com.Luoyi.server.impl.RabbitPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/point")
public class PointsExchangeController {

    @Autowired
    private PointsExchangeService pointsExchangeService;
    @Autowired
    private RabbitPublisher rabbitPublisher;
    @Autowired
    private PointsProductsService pointsProductsService;
    /*
     * @Description: 新增积分订单
     * @param pointsExchangeDTO
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/6/1 20:47
     */
    @RequestMapping("/addexchange")
    public Result addUserPoints(@RequestBody PointsExchangeDTO pointsExchangeDTO){
        //创建积分订单记录实体
        String uuid = UUID.randomUUID().toString();
        PointsExchange pointsExchange = new PointsExchange();
        pointsExchange.setUserId(pointsExchangeDTO.getUserId());
        pointsExchange.setProductId(pointsExchangeDTO.getId());
        pointsExchange.setExchangePoints(pointsExchangeDTO.getPoints());
        pointsExchange.setTrackingNumber(uuid);
        //创建积分订单记录
        pointsExchangeService.addPointsExchange(pointsExchange);

        //异步扣减积分商品库存和扣减用户积分
        rabbitPublisher.reducesPoints(pointsExchangeDTO);
        return Result.success();
    }
    /*
     * @Description: 根据用户获取积分订单
     * @param userId
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/6/2 9:12
     */
    @RequestMapping("/getexchange")
    public Result getUserPoints(Integer userId){
        List<PointsExchangeVO> pointsExchangeVOS = new ArrayList<>();
        List<PointsExchange> pointsExchangeList = pointsExchangeService.getByUserId(userId);
        //循环添加名称
        for (PointsExchange pointsExchange : pointsExchangeList) {
            PointsProducts pointsProducts = pointsProductsService.selectById(pointsExchange.getProductId());
            PointsExchangeVO pointsExchangeVO = new PointsExchangeVO(pointsExchange.getTrackingNumber(),
                    pointsProducts.getName(),pointsExchange.getExchangePoints(),pointsExchange.getExchangeTime(),
                    pointsExchange.getStatus());
            pointsExchangeVOS.add(pointsExchangeVO);
        }
        return Result.success(pointsExchangeVOS);
    }
    /*
     * @Description: 获取所有积分订单
     * @param
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/6/4 11:17
     */
    @RequestMapping("/getallexchange")
    public Result getallExchages(){
        List<PointsExchange> allPointsExchange = pointsExchangeService.getAllPointsExchange();
        return Result.success(allPointsExchange);
    }
    /*
     * @Description: 修改订单状态
     * @param id
     * @return com.Luoyi.bean.Result
     * @Author: 落一.
     * @Date: 2025/6/4 11:41
     */
    @RequestMapping("/updateexchangestatus")
    public Result updateStatus(Integer id,Integer status){
        pointsExchangeService.updatePointsExchange(id,status);
        return Result.success();
    }




}
