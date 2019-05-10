package com.graduationproject.shareddoctor.web;

import com.graduationproject.shareddoctor.Entity.Thirdparty;
import com.graduationproject.shareddoctor.service.ThirdpartyService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/5/6
 **/
@CrossOrigin
@RestController
public class ThirdPartyController {
    @Autowired
    ThirdpartyService thirdpartyService;

    @PostMapping("/thirdparty/addThirdparty")
    public ReturnUtil addTimeslot(@RequestBody Thirdparty thirdparty){
        return thirdpartyService.addThirdparty(thirdparty.getOrderId(),thirdparty.getServiceId());
    }
}
