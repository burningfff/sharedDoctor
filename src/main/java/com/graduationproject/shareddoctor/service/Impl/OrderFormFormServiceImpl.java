package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.OrderForm;
import com.graduationproject.shareddoctor.Entity.Thirdparty;
import com.graduationproject.shareddoctor.Entity.Timeslot;
import com.graduationproject.shareddoctor.respository.OrderFormRepository;
import com.graduationproject.shareddoctor.respository.ThirdpartyRepository;
import com.graduationproject.shareddoctor.respository.TimeslotRepository;
import com.graduationproject.shareddoctor.service.OrderFormService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class OrderFormFormServiceImpl implements OrderFormService {
    @Autowired
    OrderFormRepository orderFormFormRepository;
    @Autowired
    TimeslotRepository timeslotRepository;
    @Autowired
    ThirdpartyRepository thirdpartyRepository;

    @Override
    public ReturnUtil findOrderByOrderId(String orderFormId) {
        OrderForm orderFormForm = orderFormFormRepository.findOrderByOrderId(orderFormId);
        return ReturnUtil.ok(orderFormForm);
    }

    @Override
    public ReturnUtil findAllByPatientId(String patientId){
        return ReturnUtil.ok(orderFormFormRepository.findAllByPatientId(patientId));
    }

    @Override
    public ReturnUtil findOrderFormByTimeId(String timeId){
        return ReturnUtil.ok(orderFormFormRepository.findOrderFormByTimeId(timeId));
    }

    @Override
    public ReturnUtil deleteOrderByOrderId(String orderFormId){
        return ReturnUtil.ok(orderFormFormRepository.deleteOrderByOrderId(orderFormId));
    }

    @Override
    public ReturnUtil addOrder(String timeId,String patientId){
        OrderForm orderForm =new OrderForm();
        orderForm.setPatientId(patientId);
        orderForm.setTimeId(timeId);
        orderFormFormRepository.save(orderForm);
        Timeslot timeslot=timeslotRepository.findTimeslotByTimeId(timeId);
        timeslot.setIsOrdered(1);
        timeslotRepository.save(timeslot);
        Thirdparty thirdparty=new Thirdparty();
        thirdparty.setOrderId(orderForm.orderId);
        thirdparty.setCreateDate(new Date());
        thirdpartyRepository.save(thirdparty);
        return ReturnUtil.ok(orderForm);
    }

}
