package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.Entity.User;
import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * Create by cy on 2018/6/12
 */


public interface UserService {
//    ReturnUtil signIn(String userName, String password);
//
//    //修改密码
//    ReturnUtil changePassword(String password, String userId);
//
    //根据id查找user
    ReturnUtil findByUserId(String id);

    ReturnUtil addUser(User user);
//
//    ReturnUtil checkUserName(String userName);

//    ReturnUtil signUp(String userName, String password, Integer identity, Integer departId);
}
