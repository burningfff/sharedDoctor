package com.graduationproject.shareddoctor.web;


import com.graduationproject.shareddoctor.Entity.Timeslot;
import com.graduationproject.shareddoctor.service.TimeslotService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

@CrossOrigin
@RestController
public class TimeslotController {

    @Autowired
    TimeslotService timeslotService;


    @PostMapping("/timeslot/findTimeslotByTimeId")
    public ReturnUtil findTimeslotByTimeId(@RequestBody Timeslot timeslot){
        return timeslotService.findTimeslotByTimeId(timeslot.getTimeId());
    }

    @PostMapping("/timeslot/findAllByDoctorIdAndServiceType")
    public ReturnUtil findAllByDoctorIdAndServiceType(@RequestBody Timeslot timeslot){
        return timeslotService.findAllByDoctorIdAndServiceType(timeslot.getDoctorId(),timeslot.getServiceType());
    }

    @PostMapping("/timeslot/addTimeslot")
    public ReturnUtil addTimeslot(@RequestBody Timeslot timeslot){
        return timeslotService.addTimeslot(timeslot.getDoctorId(),timeslot.getStartTime(),timeslot.getEndTime(),timeslot.getServiceId(),timeslot.getServiceType());
    }

    @PostMapping("/timeslot/deleteTimeslotByTimeId")
    public ReturnUtil deleteTimeslotByTimeId(@RequestBody Timeslot timeslot){
        return timeslotService.deleteTimeslotByTimeId(timeslot.getTimeId());
    }

    @PostMapping("/timeslot/deleteTimeslotByServiceId")
    public ReturnUtil deleteTimeslotByServiceId(@RequestBody Timeslot timeslot){
        return timeslotService.deleteTimeslotByServiceId(timeslot.getServiceId());
    }



}
