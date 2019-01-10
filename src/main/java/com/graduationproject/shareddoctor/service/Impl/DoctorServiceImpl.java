package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Doctor;
import com.graduationproject.shareddoctor.respository.DoctorRepository;
import com.graduationproject.shareddoctor.service.DoctorService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


/**
 * Create by cy on 2018/6/13
 */
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public ReturnUtil findDoctorByDoctorId(String doctorId) {
        Doctor  doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        return ReturnUtil.ok(doctor);

    }
}
