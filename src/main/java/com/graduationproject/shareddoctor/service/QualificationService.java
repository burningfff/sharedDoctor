package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * Create by cy on 2018/6/12
 */


public interface QualificationService {

    //根据id查找Qualification
    ReturnUtil findQualificationByQualificationId(String qualificationId);
}
