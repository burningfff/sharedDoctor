package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;

import java.util.Date;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

public interface TimeslotService {

    //根据id查找Timeslot
    ReturnUtil findTimeslotByTimeId(String timeId);

    ReturnUtil addTimeslot(String doctorId, Date startTime,Date endTime,String serviceId,Integer serviceType);

    ReturnUtil deleteTimeslotByTimeId(String timeId);

    ReturnUtil findAllByDoctorIdAndServiceType(String doctorId,Integer serviceType);

    ReturnUtil deleteTimeslotByServiceId(String serviceId);

}
