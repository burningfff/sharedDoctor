package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.*;
import com.graduationproject.shareddoctor.respository.*;
import com.graduationproject.shareddoctor.service.DoctorService;
import com.graduationproject.shareddoctor.utils.PoiUtils;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;


/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    BalanceRepository balanceRepository;
    @Autowired
    QualificationRepository qualificationRepository;

    @Override
    public ReturnUtil findDoctorByDoctorId(String doctorId) {
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        return ReturnUtil.ok(doctor);
    }

    @Override
    public ReturnUtil updateDoctorAllData(String doctorName, Integer gender, Integer age,
                                          String phone, String email,String introduction, String doctorId){
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        doctor.setDoctorName(doctorName);
        doctor.setGender(gender);
        doctor.setAge(age);
        doctor.setPhone(phone);
        doctor.setEmail(email);
        doctor.setIntroduction(introduction);
        doctorRepository.save(doctor);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updateDoctorBasicData(String doctorName, Integer gender, Integer age
                                            ,Integer identityCard, String doctorId){
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        doctor.setDoctorName(doctorName);
        doctor.setGender(gender);
        doctor.setAge(age);
        doctor.setIdentityCard(identityCard);
        doctorRepository.save(doctor);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updateDoctorContact( String phone, String email, String locationId, String doctorId){
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        doctor.setPhone(phone);
        doctor.setEmail(email);
        //缺更新地址
        doctorRepository.save(doctor);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updateDoctorIntroduction(String introduction, String doctorId){
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        doctor.setIntroduction(introduction);
        doctorRepository.save(doctor);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updateDoctorImageUrl(String imageUrl, String doctorId){
        Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
        doctor.setImageUrl(imageUrl);
        doctorRepository.save(doctor);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil addFromExcel(MultipartFile file){
        List<Doctor> doctors = PoiUtils.importDoctor2List(file);
        for (Doctor doctor : doctors) {
            if(userRepository.findUserByUserName(doctor.getDoctorName())!=null){
                return ReturnUtil.err("用户"+doctor.getDoctorName()+"的用户名重复");
            }
        }
        for (Doctor doctor : doctors) {
            User user = new User();
            user.setUserName(doctor.doctorName);
            user.setPassword(doctor.doctorName);
            user.setIdentity(1);
            user.setCreateDate(new Date());
            userRepository.save(user);

            Location location = new Location();
            locationRepository.save(location);
            Balance balance = new Balance();
            balanceRepository.save(balance);
            Qualification qualification = new Qualification();
            qualificationRepository.save(qualification);


            doctor.setDoctorId(user.userId);
            doctor.setLocationId(location.locationId);
            doctor.setBalanceId(balance.balanceId);
            doctor.setQualificationId(qualification.qualificationId);

            doctorRepository.save(doctor);
        }
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil deleteDoctor(String doctorId){
        doctorRepository.deleteById(doctorId);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil findAllDoctor(Integer pageNum, Integer pageSize){
        Sort sort = new Sort(Sort.Direction.DESC, "doctorId");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        return ReturnUtil.ok(doctorRepository.findAll(pageable));
    }

    @Override
    public Long getAllDoctorNum() {
        return doctorRepository.count();
    }
}
