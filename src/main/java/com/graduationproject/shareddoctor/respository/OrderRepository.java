package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface OrderRepository extends JpaRepository<Order,String> {

    Order findOrderByOrderId(String orderId);
    
}
