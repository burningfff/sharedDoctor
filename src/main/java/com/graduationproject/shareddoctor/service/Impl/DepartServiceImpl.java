package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Depart;
import com.graduationproject.shareddoctor.respository.DepartRepository;
import com.graduationproject.shareddoctor.service.DepartService;
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
public class DepartServiceImpl implements DepartService {
    @Autowired
    DepartRepository departRepository;

    @Override
    public ReturnUtil findDepartByDepartId(Integer departId) {
        Depart depart=departRepository.findDepartByDepartId(departId);
        return ReturnUtil.ok(depart);
    }
}
