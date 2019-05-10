package com.graduationproject.shareddoctor.service;

import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/5/6
 **/
public interface ThirdpartyService {

    ReturnUtil addThirdparty(String orderId,String serviceId);
}
