package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Patient;
import com.graduationproject.shareddoctor.respository.PatientRepository;
import com.graduationproject.shareddoctor.service.PatientService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public ReturnUtil findPatientByPatientId(String patientId) {
        Patient patient=patientRepository.findPatientByPatientId(patientId);
        return ReturnUtil.ok(patient);
    }
}
