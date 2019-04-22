package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Timeslot;
import com.graduationproject.shareddoctor.respository.TimeslotRepository;
import com.graduationproject.shareddoctor.service.TimeslotService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class TimeslotServiceImpl implements TimeslotService {
    @Autowired
    TimeslotRepository timeslotRepository;

    @Override
    public ReturnUtil findTimeslotByTimeId(String timeId) {
        Timeslot timeslot=timeslotRepository.findTimeslotByTimeId(timeId);
        return ReturnUtil.ok(timeslot);
    }

    @Override
    public ReturnUtil addTimeslot(String doctorId, Date startTime, Date endTime, String serviceId,Integer serviceType) {

        Timeslot timeslot=new Timeslot();
        timeslot.setDoctorId(doctorId);
        timeslot.setStartTime(startTime);
        timeslot.setEndTime(endTime);
        timeslot.setServiceId(serviceId);
        timeslot.setServiceType(serviceType);
        timeslot.setIsOrdered(0);
        timeslotRepository.save(timeslot);
        return ReturnUtil.ok("添加成功");
    }

    @Override
    public ReturnUtil deleteTimeslotByTimeId(String timeId) {
        timeslotRepository.deleteById(timeId);
        return ReturnUtil.ok("删除成功");
    }

    @Override
    public ReturnUtil deleteTimeslotByServiceId(String serviceId) {
        List<Timeslot> timeslots=timeslotRepository.findAllByServiceId(serviceId);
        for(Timeslot timeslot:timeslots){
            timeslotRepository.deleteById(timeslot.timeId);
        }
        return ReturnUtil.ok("删除成功");
    }

    @Override
    public ReturnUtil findAllByDoctorIdAndServiceType(String doctorId,Integer serviceType) {
        return ReturnUtil.ok(timeslotRepository.findAllByDoctorIdAndServiceTypeOrderByStartTimeAsc(doctorId,serviceType));
    }


}
