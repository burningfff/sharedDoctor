package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Thirdparty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/4/17
 **/
public interface ThirdpartyRepository  extends JpaRepository<Thirdparty,String> {

    Thirdparty findThirdpartyByOrderId(String OrderId);

}
