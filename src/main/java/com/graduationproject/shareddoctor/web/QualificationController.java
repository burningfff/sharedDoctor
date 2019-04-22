package com.graduationproject.shareddoctor.web;


import com.graduationproject.shareddoctor.Entity.Qualification;
import com.graduationproject.shareddoctor.service.QualificationService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

@CrossOrigin
@RestController
public class QualificationController {

    @Autowired
    QualificationService qualificationService;


    @PostMapping("/qualification/findQualificationByQualificationId")
    public ReturnUtil findQualificationByQualificationId(@RequestBody Qualification qualification){
        return qualificationService.findQualificationByQualificationId(qualification.getQualificationId());
    }

    @PostMapping("/qualification/updateQualificationByQualificationId")
    public ReturnUtil updateQualificationByQualificationId(@RequestBody Qualification qualification){
        return qualificationService.updateQualificationByQualificationId(qualification.getQualificationId(),qualification.getIsConfirmed());
    }

    @PostMapping("/qualification/updateQualificationInfoByQualificationId")
    public ReturnUtil updateQualificationInfoByQualificationId(@RequestBody Qualification qualification){
        return qualificationService.updateQualificationInfoByQualificationId(qualification.getQualificationId(),qualification.getPositionId(),qualification.getHospitalId(),qualification.getImageUrl());
    }


}
