package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Position;
import com.graduationproject.shareddoctor.respository.PositionRepository;
import com.graduationproject.shareddoctor.service.PositionService;
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
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public ReturnUtil findPositionByPositionId(Integer positionId) {
        Position position=positionRepository.findPositionByPositionId(positionId);
        return ReturnUtil.ok(position);
    }
}
