package com.Luoyi.server;

import com.Luoyi.bean.dto.UserPointsDTO;

public interface UserPointsService {

    int selectPointByUserId(Integer id);

    int updatePoints(UserPointsDTO userPointsDTO);

}
