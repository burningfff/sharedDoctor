package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Depart;
import com.graduationproject.shareddoctor.respository.DepartRepository;
import com.graduationproject.shareddoctor.service.DepartService;
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
public class DepartServiceImpl implements DepartService {
    @Autowired
    DepartRepository departRepository;

    @Override
    public ReturnUtil findDepartByDepartId(Integer departId) {
        Depart depart=departRepository.findDepartByDepartId(departId);
        return ReturnUtil.ok(depart);
    }

    @Override
    public ReturnUtil addDepart(String departName){
        Depart depart=new Depart();
        depart.setDepartName(departName);
        departRepository.save(depart);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil deleteDepart(Integer departId){
        departRepository.deleteById(departId);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil updateDepart(String departName,Integer departId){
        Depart depart=new Depart();
        depart = departRepository.findDepartByDepartId(departId);
        depart.setDepartName(departName);
        departRepository.save(depart);
        return ReturnUtil.ok();
    }

    @Override
    public ReturnUtil findDepartByDepartName(String departName){
        Depart depart=new Depart();
        depart = departRepository.findDepartByDepartName(departName);
        return ReturnUtil.ok(depart);
    }

    @Override
    public ReturnUtil findAllDepart(){
        List<Depart> allDepart = departRepository.findAll();
        return ReturnUtil.ok(allDepart);
    }

    @Override
    public ReturnUtil findDepartIdByDepartName(String departName){
        return ReturnUtil.ok(departRepository.findDepartByDepartName(departName).departId);
    }
}
