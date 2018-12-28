package com.graduationproject.shareddoctor.web;

import com.graduationproject.shareddoctor.pojo.User;
import com.graduationproject.shareddoctor.service.UserService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by cy on 2018/6/13
 */

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

//    @PostMapping("/user/signIn")
//    public ReturnUtil signIn(@RequestBody User user){
//        return userService.signIn(user.getUserName(),user.getPassword());
//    }
//
//    @PostMapping("/user/changePassword")
//    public ReturnUtil changePassword(@RequestBody User user){
//        return userService.changePassword(user.getPassword(),user.getId());
//    }
    @PostMapping("/user/findByUserId")
    public ReturnUtil findByUserId(@RequestBody User user){
        return userService.findUserById(user.getId());
    }
//
//    @PostMapping("/user/checkUserName")
//    public ReturnUtil checkUserName(@RequestBody User user){
//        return userService.checkUserName(user.getUserName());
//    }

//    @PostMapping("/user/signUp")
//    public ReturnUtil signUp(@RequestBody User user){
//        return userService.signUp(user.userName,user.password,user.identity,user.departId);
//    }
}
