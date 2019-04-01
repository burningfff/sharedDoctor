package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Hospital;
import com.graduationproject.shareddoctor.respository.HospitalRepository;
import com.graduationproject.shareddoctor.service.HospitalService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public ReturnUtil findHospitalByHospitalId(String hospitalId) {
        Hospital hospital=hospitalRepository.findHospitalByHospitalId(hospitalId);
        return ReturnUtil.ok(hospital);
    }

    @Override
    public ReturnUtil findAllByHospitalNameContaining(String hospitalName) {
        List<Hospital> hospitalList=hospitalRepository.findAllByHospitalNameContaining(hospitalName);
        return ReturnUtil.ok(hospitalList);
    }


}
