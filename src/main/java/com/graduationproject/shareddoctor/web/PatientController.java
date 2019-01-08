package com.graduationproject.shareddoctor.web;

import com.graduationproject.shareddoctor.Entity.Patient;
import com.graduationproject.shareddoctor.Entity.User;
import com.graduationproject.shareddoctor.service.PatientService;
import com.graduationproject.shareddoctor.service.UserService;
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
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/patient/findPatientByPatientId")
    public ReturnUtil findPatientByPatientId(@RequestBody Patient patient){
        return patientService.findPatientByPatientId(patient.getPatientId());
    }

}
