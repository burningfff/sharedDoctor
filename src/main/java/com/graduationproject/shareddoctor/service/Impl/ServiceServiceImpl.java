package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Service;
import com.graduationproject.shareddoctor.respository.ServiceRepository;
import com.graduationproject.shareddoctor.service.ServiceService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public ReturnUtil findServiceByServiceId(String serviceId) {
        Service service=serviceRepository.findServiceByServiceId(serviceId);
        return ReturnUtil.ok(service);
    }
}
