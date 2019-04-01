package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface HospitalRepository extends JpaRepository<Hospital,String> {

    Hospital findHospitalByHospitalId(String hospitalId);

    List<Hospital> findAllByHospitalNameContaining(String hospitalName);
}
