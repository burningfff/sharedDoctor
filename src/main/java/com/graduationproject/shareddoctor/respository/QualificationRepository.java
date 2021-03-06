package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface QualificationRepository extends JpaRepository<Qualification,String> {

    Qualification findQualificationByQualificationId(String qualificationId);

    List<Qualification> findAllByHospitalId(String hospitalId);

    void deleteQualificationByQualificationId(String qualificationId);
}
