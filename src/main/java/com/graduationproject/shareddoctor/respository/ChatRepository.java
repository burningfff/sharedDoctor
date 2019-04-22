package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/4/17
 **/
public interface ChatRepository extends JpaRepository<Chat,String> {

    List<Chat> findAllByPatientId(String PatientId);

    List<Chat> findAllByDoctorId(String DoctorId);
}
