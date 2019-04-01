package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Illness;
import com.graduationproject.shareddoctor.respository.IllnessRepository;
import com.graduationproject.shareddoctor.service.IllnessService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class IllnessServiceImpl implements IllnessService {
    @Autowired
    IllnessRepository illnessRepository;

    @Override
    public ReturnUtil findIllnessByIllnessId(Integer illnessId) {
        Illness illness=illnessRepository.findIllnessByIllnessId(illnessId);
        return ReturnUtil.ok(illness);
    }

    @Override
    public ReturnUtil findAllByIllnessNameContaining(String illnessName) {
        List<Illness> illnessList=illnessRepository.findAllByIllnessNameContaining(illnessName);
        return ReturnUtil.ok(illnessList);
    }
}
