package com.Luoyi.server.impl;

import com.Luoyi.bean.PointsExchange;
import com.Luoyi.mapper.PointsExchangeMapper;
import com.Luoyi.server.PointsExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointsExchangeServiceImpl implements PointsExchangeService {
    @Autowired
    private PointsExchangeMapper pointsExchangeMapper;

    /*
     * @Description: 添加积分订单记录
     * @param pointsExchange
     * @return int
     * @Author: 落一.
     * @Date: 2025/5/31 14:43
     */
    @Override
    public int addPointsExchange(PointsExchange pointsExchange) {
        return pointsExchangeMapper.insert(pointsExchange);
    }
    /*
     * @Description: 修改积分订单记录
     * @param pointsExchange
     * @return int
     * @Author: 落一.
     * @Date: 2025/5/31 14:45
     */
    @Override
    public int updatePointsExchange(Integer id,Integer status) {
        return pointsExchangeMapper.update(id,status);
    }
    /*
     * @Description: 获取积分订单
     * @param
     * @return java.util.List<com.Luoyi.bean.PointsExchange>
     * @Author: 落一.
     * @Date: 2025/5/31 14:45
     */
    @Override
    public List<PointsExchange> getAllPointsExchange() {
        return pointsExchangeMapper.selectAll();
    }
    /*
     * @Description: 根据id积分订单
     * @param id
     * @return com.Luoyi.bean.PointsExchange
     * @Author: 落一.
     * @Date: 2025/5/31 14:45
     */
    @Override
    public PointsExchange getById(Integer id) {
        return pointsExchangeMapper.selectById(id);
    }
    /*
     * @Description: 根据用户id积分订单
     * @param userId
     * @return com.Luoyi.bean.PointsExchange
     * @Author: 落一.
     * @Date: 2025/5/31 14:45
     */
    @Override
    public List<PointsExchange> getByUserId(Integer userId) {
        return pointsExchangeMapper.selectByUserId(userId);
    }
}
