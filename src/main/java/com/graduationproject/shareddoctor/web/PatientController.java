package com.graduationproject.shareddoctor.web;

import com.graduationproject.shareddoctor.Entity.Patient;
import com.graduationproject.shareddoctor.Entity.User;
import com.graduationproject.shareddoctor.service.PatientService;
import com.graduationproject.shareddoctor.service.UserService;
import com.graduationproject.shareddoctor.utils.Page;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

@CrossOrigin
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/patient/findPatientByPatientId")
    public ReturnUtil findPatientByPatientId(@RequestBody Patient patient){
        return patientService.findPatientByPatientId(patient.getPatientId());
    }

    @PostMapping("/patient/addFromExcel")
    public ReturnUtil addFromExcel(@RequestParam MultipartFile file) throws Exception {
        return patientService.addFromExcel(file);
    }

    @PostMapping("/patient/findAllPatient")
    public ReturnUtil findAllPatient(@RequestBody Page page){
        return patientService.findAllPatient(page.pageNum,page.pageSize);
    }

    @PostMapping("/patient/deletePatient")
    public ReturnUtil deletePatient (@RequestBody Patient patient){
        return patientService.deletePatient(patient.getPatientId());
    }

    @PostMapping("/patient/updatePatientAllData")
    public ReturnUtil updatePatientAllData(@RequestBody Patient patient){
        return patientService.updatePatientAllData(patient.getPatientName(),patient.getGender(),
                patient.getAge(),patient.getIdentityCard(),patient.getPhone(),patient.getEmail(),patient.getPatientId());
    }

    @PostMapping("/patient/updatePatientBasicData")
    public ReturnUtil updatePatientBasicData(@RequestBody Patient patient){
        return patientService.updatePatientBasicData(patient.getPatientName(),patient.getGender(),patient.getAge(),
                patient.getIdentityCard(),patient.getPatientId());
    }

    @PostMapping("/patient/updatePatientContact")
    public ReturnUtil updatePatientContact(@RequestBody Patient patient){
        return patientService.updatePatientContact(patient.getPhone(),patient.getEmail(),patient.getLocationId(),patient.getPatientId());
    }

    @PostMapping("/patient/updatePatientImageUrl")
    public ReturnUtil updatePatientImageUrl(@RequestBody Patient patient){
        return patientService.updatePatientImageUrl(patient.getImageUrl(),patient.getPatientId());
    }
    
}
