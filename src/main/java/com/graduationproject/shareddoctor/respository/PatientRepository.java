package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/3
 **/
@Repository
public interface PatientRepository extends JpaRepository<Patient,String> {

    Patient findPatientByPatientId(String patientId);
}