package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.User;
import com.graduationproject.shareddoctor.respository.UserRepository;
import com.graduationproject.shareddoctor.service.UserService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * Create by cy on 2018/6/13
 */
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    StudentDao studentDao;
//    @Autowired
//    TeacherDao teacherDao;
//

    @Override
    public ReturnUtil findByUserId(String userId) {
        User user=userRepository.findByUserId(userId);
        return ReturnUtil.ok(user);
    }

    @Override
    public ReturnUtil addUser(User user) {
        userRepository.save(user);
        return ReturnUtil.ok("插入成功");
    }


//    @Override
//    public ReturnUtil signIn(String userName, String password) {
//        User user = userRepository.findUserByName(userName);
//        if (user == null) return ReturnUtil.err("用户不存在!");
//        if (!user.password.equals(password)) return ReturnUtil.err("密码错误！");
//        if(user.identity==0){
//            //返回学生信息
//            Student student = studentDao.findStudentByName(user.userName);
//            return ReturnUtil.ok(student);
//        }
//        else if(user.identity==1){
//            //返回教师信息
//            Teacher teacher = teacherDao.findTeacherByName(user.userName);
//            return ReturnUtil.ok(teacher);
//        }
//        else if(user.identity==2){
//            //返回超级用户信息
//            return  ReturnUtil.ok("root");
//        }
//        return ReturnUtil.ok();
//    }
//

//
//    @Override
//    public ReturnUtil changePassword(String password,String userId){
//        if (password.length() > 50)
//        {
//            return ReturnUtil.err("密码过长！");
//        }else if (password.length() < 6)
//        {
//            return ReturnUtil.err("密码过短！");
//        }
//        userRepository.changePassword(password,userId);
//        return ReturnUtil.ok();
//    }
//
//    @Override
//    public ReturnUtil checkUserName(String userName) {
//        if(userRepository.findUserByName(userName)!=null){
//            return ReturnUtil.err("用户名已被占用");
//        }
//        return ReturnUtil.ok();
//    }


//    @Override
//    public ReturnUtil signUp(String userName, String password, Integer identity, Integer departId) {
//        //对用户输入进行合法性检查
//        if (userName.length() > 50) return ReturnUtil.err("用户名过长！");
//        if (password.length() > 50) return ReturnUtil.err("密码过长！");
//        if (identity != 0 && identity != 1) return ReturnUtil.err("身份认证错误！");
//        if (userRepository.findUserByName(userName) != null) return ReturnUtil.err("用户名重复，请更换用户名！");
//        User user = new User();
//        String uid = IdUtil.generateId15();
//        user.setId(uid);
//        user.setUserName(userName);
//        user.setPassword(password);
//        user.setIdentity(identity);
//        userRepository.addUser(user);
//        if (identity == 0) {
//            Student student = new Student();
//            student.setStudentId(uid);
//            student.setStudentName(userName);
//            student.setDepartId(departId);
//            studentDao.addStudent(student);
//        }
//        if (identity == 1) {
//            Teacher teacher = new Teacher();
//            teacher.setTeacherId(uid);
//            teacher.setTeacherName(userName);
//            teacher.setDepartId(departId);
//            teacherDao.addTeacher(teacher);
//        }
//        return ReturnUtil.ok();
//    }
}
