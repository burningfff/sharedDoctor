package com.graduationproject.shareddoctor.service;

import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

public interface OrderFormService {
    //根据id查找Order
    ReturnUtil findOrderByOrderId(String orderId);

    ReturnUtil findAllByPatientId(String patientId);

    ReturnUtil findOrderFormByTimeId(String timeId);

    ReturnUtil findOrderFormByChatId(String chatId);

    ReturnUtil deleteOrderByOrderId(String orderId);

    ReturnUtil addOrder(String timeId,String patientId,String chatId);


}

