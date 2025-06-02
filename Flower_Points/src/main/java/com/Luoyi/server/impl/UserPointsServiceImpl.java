package com.Luoyi.server.impl;

import com.Luoyi.bean.dto.UserPointsDTO;
import com.Luoyi.mapper.UserPointsMapper;
import com.Luoyi.server.UserPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPointsServiceImpl implements UserPointsService {

    @Autowired
    private UserPointsMapper userPointsMapper;

    @Override
    public int selectPointByUserId(Integer id) {
        return userPointsMapper.getUserPointsById(id);
    }

    @Override
    public int updatePoints(UserPointsDTO userPointsDTO) {
        //扣减积分
        Integer newpoints = userPointsDTO.getAvailablePoints() - userPointsDTO.getPoints();
        return userPointsMapper.updateUserPoints(userPointsDTO.getUserId(),newpoints);
    }
}
