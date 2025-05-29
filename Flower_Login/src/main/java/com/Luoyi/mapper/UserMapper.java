package com.Luoyi.mapper;

import com.Luoyi.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from users where username = #{username}")
    User queryUserByUsername(String username);

    @Select("select * from users where username = #{username} and password = #{password}")
    User queryUserByUsernameAndPassword(String username,String password);

    @Select("select * from users where username = #{username} and password = #{password} and role = 1")
    User adminlogin(String username,String password);

    @Select("select * from users where id = #{id}")
    User queryUserById(Integer id);

    @Insert("insert into users(username, password, phone, role, level) " +
            "values(#{username}, #{password}, #{phone}, #{role}, #{level})")
    int insertUser(User user);

    @Update("update users set username=#{username}, password=#{password}, " +
            "phone=#{phone}, role=#{role}, level=#{level} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from users where id = #{id}")
    int deleteUserById(Integer id);
}
