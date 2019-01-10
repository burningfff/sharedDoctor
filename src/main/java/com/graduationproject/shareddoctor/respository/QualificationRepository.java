package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface QualificationRepository extends JpaRepository<Qualification,String> {

    Qualification findQualificationByQualificationId(String qualificationId);

}
