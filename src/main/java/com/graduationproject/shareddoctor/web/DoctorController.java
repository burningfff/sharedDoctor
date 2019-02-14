package com.graduationproject.shareddoctor.web;

import com.graduationproject.shareddoctor.Entity.Doctor;
import com.graduationproject.shareddoctor.service.DoctorService;
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
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/doctor/findDoctorByDoctorId")
    public ReturnUtil findDoctorByDoctorId(@RequestBody Doctor doctor){
        return doctorService.findDoctorByDoctorId(doctor.getDoctorId());
    }

    @PostMapping("/doctor/updateDoctorBasicData")
    public ReturnUtil updateDoctorBasicData(@RequestBody Doctor doctor){
        return doctorService.updateDoctorBasicData(doctor.getDoctorName(),doctor.getGender(),doctor.getAge(),doctor.getIdentityCard(),doctor.getDoctorId());
    }

    @PostMapping("/doctor/updateDoctorContact")
    public ReturnUtil updateDoctorContact(@RequestBody Doctor doctor){
        return doctorService.updateDoctorContact(doctor.getPhone(),doctor.getEmail(),doctor.getLocationId(),doctor.getDoctorId());
    }

    @PostMapping("/doctor/updateDoctorIntroduction")
    public ReturnUtil updateDoctorIntroduction(@RequestBody Doctor doctor){
        return doctorService.updateDoctorIntroduction(doctor.getIntroduction(),doctor.getDoctorId());
    }


    @PostMapping("/doctor/updateDoctorImageUrl")
    public ReturnUtil updateDoctorImageUrl(@RequestBody Doctor doctor){
        return doctorService.updateDoctorImageUrl(doctor.getImageUrl(),doctor.getDoctorId());
    }


}
