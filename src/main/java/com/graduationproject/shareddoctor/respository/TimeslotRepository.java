package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Qualification;
import com.graduationproject.shareddoctor.Entity.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface TimeslotRepository extends JpaRepository<Timeslot,String> {

    Timeslot findTimeslotByTimeId(String timeId);
    
}
