package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

public interface PatientService {

    //从文件导入患者
    ReturnUtil addFromExcel(MultipartFile file);

    //根据id查找Patient
    ReturnUtil findPatientByPatientId(String patientId);
    
    //根据页码和页面大小返回当前页所有患者信息
    ReturnUtil findAllPatient(Integer pageNum, Integer pageSize);

    //根据Id删除患者
    ReturnUtil deletePatient(String patientId);

    //更新医生所有资料
    ReturnUtil updatePatientAllData(String patientName, String gender, Integer age, String identityCard, String phone, String email, String patientId);

    //更新医生基础资料
    ReturnUtil updatePatientBasicData(String patientName, String gender, Integer age, String identityCard, String patientId);

    //更新医生联系方式
    ReturnUtil updatePatientContact(String phone, String email, String locationId, String patientId);

    //更新医生头像照片
    ReturnUtil updatePatientImageUrl(String imageUrl, String patientId);
}
