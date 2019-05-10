package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/3
 **/
@Repository
public interface PatientRepository extends JpaRepository<Patient,String> {

    void deletePatientByPatientId(String patientId);

    Patient findPatientByPatientId(String patientId);

    Patient findPatientByPatientName(String patientName);

    Page<Patient> findAllByPatientNameContainingOrderByPatientId(String patientName,Pageable pageable);

}