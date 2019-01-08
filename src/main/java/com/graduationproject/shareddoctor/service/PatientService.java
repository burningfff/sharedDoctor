package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * Create by cy on 2018/6/12
 */


public interface PatientService {

    //根据id查找Patient
    ReturnUtil findPatientByPatientId(String patientId);
}
