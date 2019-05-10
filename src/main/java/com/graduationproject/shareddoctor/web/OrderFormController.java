package com.graduationproject.shareddoctor.web;


import com.graduationproject.shareddoctor.Entity.OrderForm;
import com.graduationproject.shareddoctor.service.OrderFormService;
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
public class OrderFormController {

    @Autowired
    OrderFormService orderFormService;


    @PostMapping("/order/findOrderByOrderId")
    public ReturnUtil findOrderByOrderId(@RequestBody OrderForm orderForm){
        return orderFormService.findOrderByOrderId(orderForm.getOrderId());
    }

    @PostMapping("/order/findOrderFormByTimeId")
    public ReturnUtil findOrderFormByTimeId(@RequestBody OrderForm orderForm){
        return orderFormService.findOrderFormByTimeId(orderForm.getTimeId());
    }

    @PostMapping("/order/findAllByPatientId")
    public ReturnUtil findAllByPatientId(@RequestBody OrderForm orderForm){
        return orderFormService.findAllByPatientId(orderForm.getPatientId());
    }

    @PostMapping("/order/findOrderFormByChatId")
    public ReturnUtil findOrderFormByChatId(@RequestBody OrderForm orderForm){
        return orderFormService.findOrderFormByChatId(orderForm.getChatId());
    }

    @PostMapping("/order/deleteOrderByOrderId")
    public ReturnUtil deleteOrderByOrderId(@RequestBody OrderForm orderForm){
        return orderFormService.deleteOrderByOrderId(orderForm.getOrderId());
    }

    @PostMapping("/order/confirmOrderByOrderId")
    public ReturnUtil confirmOrderByOrderId(@RequestBody OrderForm orderForm){
        return orderFormService.confirmOrderByOrderId(orderForm.getOrderId());
    }

    @PostMapping("/order/addOrder")
    public ReturnUtil addOrder(@RequestBody OrderForm orderForm){
        return orderFormService.addOrder(orderForm.getTimeId(), orderForm.getPatientId(),orderForm.getChatId());
    }



}
