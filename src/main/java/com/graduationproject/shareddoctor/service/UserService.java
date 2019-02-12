package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

public interface UserService {
//  登录
    ReturnUtil signIn(String userName, String password);

//  注册
    ReturnUtil signUp(String userName, String password, Integer identity);

//  修改密码
    ReturnUtil changePassword(String password, String userId);

//根据id查找user
    ReturnUtil findUserByUserId(String userId);

//
//    ReturnUtil checkUserName(String userName);


}
