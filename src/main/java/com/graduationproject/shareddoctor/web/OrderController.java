package com.graduationproject.shareddoctor.web;


import com.graduationproject.shareddoctor.Entity.Order;
import com.graduationproject.shareddoctor.service.OrderService;
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
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("/order/findOrderByOrderId")
    public ReturnUtil findOrderByOrderId(@RequestBody Order order){
        return orderService.findOrderByOrderId(order.getOrderId());
    }

}
