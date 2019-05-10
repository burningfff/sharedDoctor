package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Service;
import com.graduationproject.shareddoctor.respository.ServiceRepository;
import com.graduationproject.shareddoctor.service.ServiceService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

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

    @Override
    public ReturnUtil findAllByDoctorId(String doctorId) {
        List<Service> serviceList=serviceRepository.findAllByDoctorId(doctorId);
        return ReturnUtil.ok(serviceList);
    }

    @Override
    public ReturnUtil deleteServiceByServiceId(String serviceId) {
        serviceRepository.deleteById(serviceId);
        return ReturnUtil.ok("删除成功");
    }

    @Override
    public ReturnUtil addService(String doctorId,String serviceName,Double price) {
        Service service=new Service();
        service.setDoctorId(doctorId);
        service.setServiceName(serviceName);
        service.setPrice(price);
        serviceRepository.save(service);
        return ReturnUtil.ok(service);
    }



}
