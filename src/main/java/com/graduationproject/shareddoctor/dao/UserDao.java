package com.graduationproject.shareddoctor.dao;

import com.graduationproject.shareddoctor.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * Create by cy on 2018/6/12
 */

@Mapper
public interface UserDao {
//    @Insert("insert into user(id,user_name,password,identity) " +
//            "values(#{user.id},#{user.userName},#{user.password},#{user.identity})")
//    void addUser(@Param("user") User user);
//
//    @Delete("delete from user where id=#{userId}")
//    void deleteUser(@Param("userId") String userId);
//
//    @Update("update user set user_name=#{userName} where id=#{userId}")
//    void updateUserName(@Param("userName") String userName, @Param("userId") String userId);
//
    @Select("select id ,user_name as userName,password," +
            "identity  from user where id=#{userId}")
    User findUserById(@Param("userId") String userId);
//
//    @Select("select id ,user_name as userName,password," +
//            "identity from user where user_name=#{userName}")
//    User findUserByName(@Param("userName") String userName);
//
//    @Update("update user set password=#{new_password} where id=#{userId}")
//    void changePassword(@Param("new_password") String new_password, @Param("userId") String userId);

}
