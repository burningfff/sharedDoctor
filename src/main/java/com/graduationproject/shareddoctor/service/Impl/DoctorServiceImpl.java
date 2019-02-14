package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Doctor;
import com.graduationproject.shareddoctor.respository.DoctorRepository;
import com.graduationproject.shareddoctor.service.DoctorService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public ReturnUtil findDoctorByDoctorId(String doctorId) {
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        return ReturnUtil.ok(doctor);
    }

    @Override
    public ReturnUtil updateDoctorBasicData(String doctorName, Integer gender, Integer age
                                            ,Integer identityCard, String doctorId){
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        doctor.setDoctorName(doctorName);
        doctor.setGender(gender);
        doctor.setAge(age);
        doctor.setIdentityCard(identityCard);
        doctorRepository.save(doctor);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updateDoctorContact( String phone, String email, String locationId, String doctorId){
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        doctor.setPhone(phone);
        doctor.setEmail(email);
        //缺更新地址
        doctorRepository.save(doctor);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updateDoctorIntroduction(String introduction, String doctorId){
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        doctor.setIntroduction(introduction);
        doctorRepository.save(doctor);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updateDoctorImageUrl(String imageUrl, String doctorId){
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        doctor.setImageUrl(imageUrl);
        doctorRepository.save(doctor);
        return ReturnUtil.ok();
    }

}
