package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.*;
import com.graduationproject.shareddoctor.respository.BalanceRepository;
import com.graduationproject.shareddoctor.respository.LocationRepository;
import com.graduationproject.shareddoctor.respository.PatientRepository;
import com.graduationproject.shareddoctor.respository.UserRepository;
import com.graduationproject.shareddoctor.service.PatientService;
import com.graduationproject.shareddoctor.utils.IdUtil;
import com.graduationproject.shareddoctor.utils.PoiUtils;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Date;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    BalanceRepository balanceRepository;

    @Override
    public ReturnUtil findPatientByPatientId(String patientId) {
        Patient patient=patientRepository.findPatientByPatientId(patientId);
        return ReturnUtil.ok(patient);
    }

    @Transactional
    @Override
    public ReturnUtil deletePatient(String patientId){
        Patient patient= patientRepository.findPatientByPatientId(patientId);
        patientRepository.deletePatientByPatientId(patientId);
        userRepository.deleteUserByUserId(patientId);
        balanceRepository.deleteBalanceByBalanceId(patient.balanceId);
        locationRepository.deleteLocationByLocationId(patient.locationId);
        return ReturnUtil.ok("删除成功");
    }

    @Override
    public ReturnUtil findAllPatient(Integer pageNum, Integer pageSize){
        Sort sort = new Sort(Sort.Direction.DESC, "patientId");
        Pageable pageable = new PageRequest(pageNum, pageSize, sort);
        return ReturnUtil.ok(patientRepository.findAll(pageable));
    }
    
    @Override
    public ReturnUtil addFromExcel(MultipartFile file){
        List<Patient> patients = PoiUtils.importPatient2List(file);
        for (Patient patient : patients) {
            if(userRepository.findUserByUserName(patient.getPatientName())!=null){
                return ReturnUtil.err("用户"+patient.getPatientName()+"的用户名重复");
            }
        }
        for (Patient patient : patients) {
            User user = new User();
            user.setUserName(patient.patientName);
            String bcryptPassword= BCrypt.hashpw( patient.patientName,BCrypt.gensalt());
            user.setPassword(bcryptPassword);
            user.setIdentity(0);
            user.setCreateDate(new Date());
            userRepository.save(user);

            Location location = new Location();
            locationRepository.save(location);
            Balance balance = new Balance();
            balanceRepository.save(balance);

            patient.setPatientId(user.userId);
            patient.setLocationId(location.locationId);
            patient.setBalanceId(balance.balanceId);
            patientRepository.save(patient);
        }
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updatePatientAllData(String patientName, String gender, Integer age,String identityCard,
                                          String phone, String email, String patientId){
        Patient patient=patientRepository.findPatientByPatientId(patientId);
        patient.setPatientName(patientName);
        patient.setGender(gender);
        patient.setAge(age);
        patient.setIdentityCard(identityCard);
        patient.setPhone(phone);
        patient.setEmail(email);
        patientRepository.save(patient);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updatePatientBasicData(String patientName, String gender, Integer age, Integer weight, String illness, String patientId){
        Patient patient=patientRepository.findPatientByPatientId(patientId);
        patient.setPatientName(patientName);
        patient.setGender(gender);
        patient.setAge(age);
        patient.setWeight(weight);
        patient.setIllness(illness);
        patientRepository.save(patient);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updatePatientContact( String phone, String email, String locationId, String patientId){
        Patient patient=patientRepository.findPatientByPatientId(patientId);
        patient.setPhone(phone);
        patient.setEmail(email);
        //缺更新地址
        patientRepository.save(patient);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updatePatientImageUrl(String imageUrl, String patientId){
        Patient patient=patientRepository.findPatientByPatientId(patientId);
        patient.setImageUrl(imageUrl);
        patientRepository.save(patient);
        return ReturnUtil.ok();
    }
}
