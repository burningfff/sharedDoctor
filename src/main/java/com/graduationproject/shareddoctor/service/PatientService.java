package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

public interface PatientService {

    //根据id查找Patient
    ReturnUtil findPatientByPatientId(String patientId);

    //从文件导入患者
    ReturnUtil addFromExcel(MultipartFile file);


}
