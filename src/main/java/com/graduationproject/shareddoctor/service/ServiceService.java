package com.graduationproject.shareddoctor.service;


import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/


public interface ServiceService {

    //根据id查找Service
    ReturnUtil findServiceByServiceId(String serviceId);

    ReturnUtil addService(String serviceName, Double price);

    ReturnUtil deleteServiceByServiceId(String serviceId);

}
