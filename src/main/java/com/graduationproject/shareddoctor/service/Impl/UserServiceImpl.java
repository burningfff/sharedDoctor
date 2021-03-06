package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.*;
import com.graduationproject.shareddoctor.respository.*;
import com.graduationproject.shareddoctor.service.UserService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    BalanceRepository balanceRepository;
    @Autowired
    QualificationRepository qualificationRepository;


    @Override
    public ReturnUtil findUserByUserId(String userId) {
        User user=userRepository.findUserByUserId(userId);
        return ReturnUtil.ok(user);
    }

    @Override
    public ReturnUtil signIn(String userName, String password) {
        User user = userRepository.findUserByUserName(userName);
        if (user == null) return ReturnUtil.err("用户不存在!");
        if (!BCrypt.checkpw(password,user.password)) return ReturnUtil.err("密码错误！");
        if(user.identity==0){
            //返回病人信息
            Patient patient = patientRepository.findPatientByPatientId(user.userId);
            return ReturnUtil.ok(patient);
        }
        else if(user.identity==1){
            //返回教师信息
            Doctor doctor = doctorRepository.findDoctorByDoctorId(user.userId);
            return ReturnUtil.ok(doctor);
        }
        else if(user.identity==2){
            //返回超级用户信息
            return  ReturnUtil.ok("root");
        }
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil signUp(String userName, String password, Integer identity) {
        //对用户输入进行合法性检查
        if (userName.length() > 16) return ReturnUtil.err("用户名过长！");
        if (password.length() > 16) return ReturnUtil.err("密码过长！");
        if (userName.length() < 6) return ReturnUtil.err("用户名过短！");
        if (password.length() < 6) return ReturnUtil.err("密码过短！");
        if (identity != 0 && identity != 1) return ReturnUtil.err("身份认证错误！");
        if (userRepository.findUserByUserName(userName) != null) return ReturnUtil.err("用户名重复，请更换用户名！");
        User user = new User();
        user.setUserName(userName);
        String bcryptPassword= BCrypt.hashpw( password,BCrypt.gensalt());
        user.setPassword(bcryptPassword);
        user.setIdentity(identity);
        user.setCreateDate(new Date());
        userRepository.save(user);
        String userId=userRepository.findUserByUserName(userName).userId;
        //患者
        if (identity == 0) {
            Location location = new Location();
            locationRepository.save(location);

            Patient patient = new Patient();
            patient.setPatientId(userId);
            patient.setLocationId(location.locationId);
            patientRepository.save(patient);
        }
        //医生
        if (identity == 1) {
            Location location = new Location();
            locationRepository.save(location);
            Balance balance = new Balance();
            balanceRepository.save(balance);
            Qualification qualification=new Qualification();
            qualification.setIsConfirmed(2);
            qualificationRepository.save(qualification);

            Doctor doctor = new Doctor();
            doctor.setDoctorId(userId);
            doctor.setLocationId(location.locationId);
            doctor.setLocationId(location.locationId);
            doctor.setBalanceId(balance.balanceId);
            doctor.setQualificationId(qualification.qualificationId);
            doctorRepository.save(doctor);
        }
        return ReturnUtil.ok("注册成功");
    }

    @Override
    public ReturnUtil changePassword(String password,String userId){
        if (password.length() > 16)
        {
            return ReturnUtil.err("密码过长！");
        }else if (password.length() < 6)
        {
            return ReturnUtil.err("密码过短！");
        }
        User user=userRepository.findUserByUserId(userId);
        user.setPassword(password);
        userRepository.save(user);
        return ReturnUtil.ok();
    }

//    @Override
//    public ReturnUtil checkUserName(String userName) {
//        if(userRepository.findUserByUserName(userName)!=null){
//            return ReturnUtil.err("用户名已被占用");
//        }
//        return ReturnUtil.ok();
//    }


}
