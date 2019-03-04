package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Timeslot;
import com.graduationproject.shareddoctor.respository.TimeslotRepository;
import com.graduationproject.shareddoctor.service.TimeslotService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

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
}