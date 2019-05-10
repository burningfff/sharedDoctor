package com.graduationproject.shareddoctor.web;


import com.graduationproject.shareddoctor.Entity.Service;
import com.graduationproject.shareddoctor.service.ServiceService;
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
public class ServiceController {

    @Autowired
    ServiceService serviceService;


    @PostMapping("/service/findServiceByServiceId")
    public ReturnUtil findServiceByServiceId(@RequestBody Service service){
        return serviceService.findServiceByServiceId(service.getServiceId());
    }

    @PostMapping("/service/findAllByDoctorId")
    public ReturnUtil findAllByDoctorId(@RequestBody Service service){
        return serviceService.findAllByDoctorId(service.getDoctorId());
    }

    @PostMapping("/service/addService")
    public ReturnUtil addService(@RequestBody Service service){
        return serviceService.addService(service.getDoctorId(),service.getServiceName(),service.getPrice());
    }

    @PostMapping("/service/deleteServiceByServiceId")
    public ReturnUtil deleteServiceByServiceId(@RequestBody Service service){
        return serviceService.deleteServiceByServiceId(service.getServiceId());
    }

}
