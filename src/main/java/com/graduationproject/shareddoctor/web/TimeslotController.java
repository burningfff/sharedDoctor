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
 * Create by cy on 2018/6/13
 */

@CrossOrigin
@RestController
public class TimeslotController {

    @Autowired
    TimeslotService timeslotService;


    @PostMapping("/timeslot/findTimeslotByTimeId")
    public ReturnUtil findTimeslotByTimeId(@RequestBody Timeslot timeslot){
        return timeslotService.findTimeslotByTimeId(timeslot.getTimeId());
    }

}
