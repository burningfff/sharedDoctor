package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * Create by cy on 2018/6/12
 */


public interface DoctorService {

    //根据id查找Doctor
    ReturnUtil findDoctorByDoctorId(String doctorId);
}
