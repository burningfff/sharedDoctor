package com.graduationproject.shareddoctor.dao;

import com.graduationproject.shareddoctor.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * Create by cy on 2018/6/12
 */

@Mapper
public interface UserDao {





//    @Select("select id ,user_name as userName,password," +
//            "identity  from user where id=#{userId}")
//    User findUserById(@Param("userId") String userId);
}
