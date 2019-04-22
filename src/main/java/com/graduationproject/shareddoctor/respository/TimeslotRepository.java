package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Qualification;
import com.graduationproject.shareddoctor.Entity.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface TimeslotRepository extends JpaRepository<Timeslot,String> {

    Timeslot findTimeslotByTimeId(String timeId);

    List<Timeslot> findAllByDoctorIdAndServiceTypeOrderByStartTimeAsc(String doctorId,Integer serviceType);

    List<Timeslot> findAllByServiceId(String serviceId);

    void deleteTimeslotByTimeId(String timeId);

    void deleteAllByDoctorId(String doctorId);

    void deleteTimeslotsByServiceId(String serviceId);
}
