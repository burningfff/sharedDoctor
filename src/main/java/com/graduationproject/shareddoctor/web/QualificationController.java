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
 * Create by cy on 2018/6/13
 */

@CrossOrigin
@RestController
public class QualificationController {

    @Autowired
    QualificationService qualificationService;


    @PostMapping("/qualification/findQualificationByQualificationId")
    public ReturnUtil findQualificationByQualificationId(@RequestBody Qualification qualification){
        return qualificationService.findQualificationByQualificationId(qualification.getQualificationId());
    }

}
