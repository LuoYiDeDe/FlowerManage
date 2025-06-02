package com.Luoyi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserPointsMapper {

    @Select("SELECT available_points FROM user_points WHERE user_id = #{id}")
    int getUserPointsById(@Param("id") int id);

    @Update("UPDATE user_points SET available_points = #{availablePoints} WHERE user_id = #{id}")
    int updateUserPoints(@Param("id") int id, @Param("availablePoints") int availablePoints);


}

