package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Order;
import com.graduationproject.shareddoctor.respository.OrderRepository;
import com.graduationproject.shareddoctor.service.OrderService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public ReturnUtil findOrderByOrderId(String orderId) {
        Order order=orderRepository.findOrderByOrderId(orderId);
        return ReturnUtil.ok(order);
    }
}
