package com.bsb.mapper;

import com.bsb.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IUserMapper {

    @Select("SELECT COUNT(1) FROM user_table WHERE username = #{username}")
    int checkUsername(String username);

    @Select("SELECT * FROM user_table WHERE username = #{username} AND password = #{password}")
    User login(@Param("username") String username,
               @Param("password") String md5EncodingPassword);

    int insertUser(User user);

    @Select("SELECT * FROM user_table WHERE username LIKE CONCAT('%', #{username}, '%')")
    User queryUserInfo(String userName);
}