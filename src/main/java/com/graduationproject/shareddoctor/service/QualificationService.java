package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

public interface QualificationService {

    //根据id查找Qualification
    ReturnUtil findQualificationByQualificationId(String qualificationId);

    //更新认证状态
    ReturnUtil updateQualificationByQualificationId(String qualificationId, Integer isConfirmed);
}
