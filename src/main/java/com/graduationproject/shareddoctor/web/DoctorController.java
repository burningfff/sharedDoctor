package com.graduationproject.shareddoctor.web;

import com.graduationproject.shareddoctor.Entity.Doctor;
import com.graduationproject.shareddoctor.Entity.Qualification;
import com.graduationproject.shareddoctor.service.DoctorService;
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
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/doctor/findDoctorByDoctorId")
    public ReturnUtil findDoctorByDoctorId(@RequestBody Doctor doctor){
        return doctorService.findDoctorByDoctorId(doctor.getDoctorId());
    }

    @PostMapping("/doctor/findAllDoctor")
    public ReturnUtil findAllDoctor(@RequestBody Page page){
        return doctorService.findAllDoctor(page.pageNum,page.pageSize);
    }

    @PostMapping("/doctor/findAllDoctorByDepartId")
    public ReturnUtil findAllDoctorByDepartId(@RequestBody Doctor doctor){
        return doctorService.findAllDoctorByDepartId(doctor.departId);
    }

    @PostMapping("/doctor/deleteDoctor")
    public ReturnUtil deleteDoctor (@RequestBody Doctor doctor){
        return doctorService.deleteDoctor(doctor.getDoctorId());
    }

    @PostMapping("/doctor/updateDoctorAllData")
    public ReturnUtil updateDoctorAllData(@RequestBody Doctor doctor){
        return doctorService.updateDoctorAllData(doctor.getDoctorName(),doctor.getGender(),doctor.getAge(),doctor.getIdentityCard(),doctor.getPhone(),doctor.getEmail(),doctor.getIntroduction(),doctor.getDoctorId());
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

    @PostMapping("/doctor/addFromExcel")
    public ReturnUtil addFromExcel(@RequestParam MultipartFile file) throws Exception {
        return doctorService.addFromExcel(file);
    }


}
