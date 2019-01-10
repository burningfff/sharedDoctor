package com.graduationproject.shareddoctor.service;

import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface HospitalService {
    //根据id查找Hospital
    ReturnUtil findHospitalByHospitalId(String hospitalId);
}

