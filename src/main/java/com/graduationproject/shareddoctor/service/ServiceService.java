package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * Create by cy on 2018/6/12
 */


public interface ServiceService {

    //根据id查找Service
    ReturnUtil findServiceByServiceId(String ServiceId);
}
