package com.graduationproject.shareddoctor.web;


import com.graduationproject.shareddoctor.Entity.Balance;
import com.graduationproject.shareddoctor.service.BalanceService;
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
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @PostMapping("/balance/findBalanceByBalanceId")
    public ReturnUtil findBalanceByBalanceId(@RequestBody Balance balance){
        return balanceService.findBalanceByBalanceId(balance.getBalanceId());
    }



}
