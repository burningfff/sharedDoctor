package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * Create by cy on 2018/6/12
 */


public interface TimeslotService {

    //根据id查找Timeslot
    ReturnUtil findTimeslotByTimeId(String timeId);
}
