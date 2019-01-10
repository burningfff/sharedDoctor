package com.graduationproject.shareddoctor.service;

import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface OrderService {
    //根据id查找Order
    ReturnUtil findOrderByOrderId(String orderId);
}

