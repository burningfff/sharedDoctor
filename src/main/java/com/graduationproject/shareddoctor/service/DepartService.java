package com.graduationproject.shareddoctor.service;

import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

public interface DepartService {
    //根据id查找Depart
    ReturnUtil findDepartByDepartId(Integer departId);
    //增加
    ReturnUtil addDepart(String departName);
    //删除
    ReturnUtil deleteDepart(Integer departId);
    //修改depart
    ReturnUtil updateDepart(String departName,Integer departId);
    //查找
    ReturnUtil findDepartByDepartName(String departName);

    ReturnUtil findAllDepart();

    ReturnUtil findDepartIdByDepartName(String departName);

    ReturnUtil findAllByDepartNameContaining(String departName);


}

