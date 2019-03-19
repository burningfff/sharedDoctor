package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Qualification;
import com.graduationproject.shareddoctor.respository.QualificationRepository;
import com.graduationproject.shareddoctor.service.QualificationService;
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
public class QualificationServiceImpl implements QualificationService {
    @Autowired
    QualificationRepository qualificationRepository;

    @Override
    public ReturnUtil findQualificationByQualificationId(String qualificationId) {
        Qualification qualification=qualificationRepository.findQualificationByQualificationId(qualificationId);
        return ReturnUtil.ok(qualification);
    }

    @Override
    public ReturnUtil updateQualificationByQualificationId(String qualificationId,Integer isConfirmed) {
        Qualification qualification=qualificationRepository.findQualificationByQualificationId(qualificationId);
        qualification.setIsConfirmed(isConfirmed);
        qualificationRepository.save(qualification);
        return ReturnUtil.ok();
    }


}
