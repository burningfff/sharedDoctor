package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Thirdparty;
import com.graduationproject.shareddoctor.respository.ThirdpartyRepository;
import com.graduationproject.shareddoctor.service.ThirdpartyService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/5/6
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class ThirdpartyServiceImpl implements ThirdpartyService {
    @Autowired
    ThirdpartyRepository thirdpartyRepository;

    @Override
    public ReturnUtil addThirdparty(String orderId, String serviceId){
        Thirdparty thirdparty=new Thirdparty();
        thirdparty.setOrderId(orderId);
        thirdparty.setServiceId(serviceId);
        thirdparty.setCreateDate(new Date());
        thirdpartyRepository.save(thirdparty);
        return ReturnUtil.ok();
    }
}
