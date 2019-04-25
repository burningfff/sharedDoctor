package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface OrderFormRepository extends JpaRepository<OrderForm,String> {

    OrderForm findOrderByOrderId(String orderId);

    List<OrderForm> findAllByPatientId(String PatientId);

    OrderForm findOrderFormByTimeId(String timeId);

    OrderForm deleteOrderByOrderId(String orderId);

    OrderForm findOrderFormByChatId(String chatId);
}
