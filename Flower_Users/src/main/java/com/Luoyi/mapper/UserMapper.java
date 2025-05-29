package com.Luoyi.mapper;

import com.Luoyi.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users")
    List<User> getAllUsers();

    @Select("select * from users where username = #{username}")
    User queryUserByUsername(String username);

    @Select("select * from users where username = #{username} and password = #{password} and role = 1")
    User adminlogin(String username,String password);

    @Update("update users set username=#{username}, password=#{password}, " +
            "phone=#{phone}, role=#{role}, level=#{level} where id = #{id}")
    int updateUser(User user);

}
