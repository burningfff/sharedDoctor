package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Balance;
import com.graduationproject.shareddoctor.respository.BalanceRepository;
import com.graduationproject.shareddoctor.service.BalanceService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * Create by cy on 2018/6/13
 */
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    BalanceRepository balanceRepository;

    @Override
    public ReturnUtil findBalanceByBalanceId(String balanceId) {
        Balance balance=balanceRepository.findBalanceByBalanceId(balanceId);
        return ReturnUtil.ok(balance);
    }
}
