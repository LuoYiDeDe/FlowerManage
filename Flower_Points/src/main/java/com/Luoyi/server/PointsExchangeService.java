package com.Luoyi.server;

import com.Luoyi.bean.PointsExchange;

import java.util.List;

public interface PointsExchangeService {

    int addPointsExchange(PointsExchange pointsExchange);

    int updatePointsExchange(PointsExchange pointsExchange);

    List<PointsExchange> getAllPointsExchange();

    PointsExchange getById(Integer id);

    List<PointsExchange> getByUserId(Integer userId);


}
