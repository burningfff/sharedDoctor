package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Doctor;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/3
 **/
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,String> {

    Doctor findDoctorByDoctorId(String doctorId);

    Doctor findDoctorByDoctorName(String doctorName);

    void deleteDoctorByDoctorId(String doctorId);

    List<Doctor> findAllByDepartId(Integer departId);
}