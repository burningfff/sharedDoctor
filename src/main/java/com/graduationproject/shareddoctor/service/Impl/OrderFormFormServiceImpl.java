package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.*;
import com.graduationproject.shareddoctor.respository.*;
import com.graduationproject.shareddoctor.service.OrderFormService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

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
    @Autowired
    ChatDetailRepository chatDetailRepository;
    @Autowired
    ChatRepository chatRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    BalanceRepository balanceRepository;

    @Override
    public ReturnUtil findOrderByOrderId(String orderFormId) {
        OrderForm orderForm = orderFormFormRepository.findOrderByOrderId(orderFormId);
        return ReturnUtil.ok(orderForm);
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
    public ReturnUtil findOrderFormByChatId(String chatId){
        return ReturnUtil.ok(orderFormFormRepository.findOrderFormByChatId(chatId));
    }

    @Override
    public ReturnUtil deleteOrderByOrderId(String orderFormId){
        OrderForm orderForm = orderFormFormRepository.findOrderByOrderId(orderFormId);
        if(orderForm.timeId!=null)
        {
            Timeslot timeslot=timeslotRepository.findTimeslotByTimeId(orderForm.timeId);
            timeslot.setIsOrdered(0);
            timeslotRepository.save(timeslot);
        }
        List<ChatDetail> chatDetails=chatDetailRepository.findAllByChatId(orderForm.chatId);
        for (ChatDetail chatDetail:chatDetails){
            chatDetailRepository.deleteById(chatDetail.chatDetailId);
        }
        chatRepository.deleteById(orderForm.chatId);
        Thirdparty thirdparty=thirdpartyRepository.findThirdpartyByOrderId(orderFormId);
        thirdpartyRepository.deleteById(thirdparty.thirdpartyId);
        orderFormFormRepository.deleteById(orderFormId);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil confirmOrderByOrderId(String orderFormId){
        Thirdparty thirdparty=thirdpartyRepository.findThirdpartyByOrderId(orderFormId);
        com.graduationproject.shareddoctor.Entity.Service service=serviceRepository.findServiceByServiceId(thirdparty.serviceId);
        Doctor doctor=doctorRepository.findDoctorByDoctorId(service.doctorId);
        Balance balance=balanceRepository.findBalanceByBalanceId(doctor.balanceId);
        Double tempBalance=balance.balance;
        tempBalance+=service.price;
        balance.setBalance(tempBalance);
        balanceRepository.save(balance);
        thirdpartyRepository.deleteById(thirdparty.thirdpartyId);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil addOrder(String timeId,String patientId,String chatId){
        OrderForm orderForm =new OrderForm();
        orderForm.setPatientId(patientId);
        orderForm.setTimeId(timeId);
        orderForm.setChatId(chatId);
        orderFormFormRepository.save(orderForm);
        if(timeId!=null)
        {
            Timeslot timeslot=timeslotRepository.findTimeslotByTimeId(timeId);
            timeslot.setIsOrdered(1);
            timeslotRepository.save(timeslot);
        }
        return ReturnUtil.ok(orderForm);
    }

}
