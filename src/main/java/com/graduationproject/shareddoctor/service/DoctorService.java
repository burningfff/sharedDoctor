package com.graduationproject.shareddoctor.service;



import com.graduationproject.shareddoctor.Entity.Doctor;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.web.multipart.MultipartFile;



/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

public interface DoctorService {

    //根据id查找Doctor
    ReturnUtil findDoctorByDoctorId(String doctorId);

    //更新医生所有资料
    ReturnUtil updateDoctorAllData(String doctorName, String gender, Integer age, String identityCard, String phone, String email, String introduction, String doctorId);

    //更新医生基础资料
    ReturnUtil updateDoctorBasicData(String doctorName, String gender, Integer age, String identityCard, String doctorId);

    //更新医生联系方式
    ReturnUtil updateDoctorContact(String phone, String email, String locationId, String doctorId);

    //更新医生个人介绍
    ReturnUtil updateDoctorIntroduction(String introduction, String doctorId);

    //更新医生头像照片
    ReturnUtil updateDoctorImageUrl(String imageUrl, String doctorId);

    //从文件导入医护人员
    ReturnUtil addFromExcel(MultipartFile file);

    //删除
    ReturnUtil deleteDoctor(String doctorId);

    //根据页码和页面大小返回当前页所有医护人员信息
    ReturnUtil findAllDoctor(Integer pageNum, Integer pageSize);

    ReturnUtil findAllDoctorByDepartId(Integer departId);

    ReturnUtil findAllDoctorByDepartName(String departName);

    ReturnUtil findAllDoctorByIllness(String IllnessName);

    ReturnUtil findAllByDoctorName(String doctorName);

    ReturnUtil findAllByHospitalName(String hospitalName);

}
