package com.graduationproject.shareddoctor.web;


import com.graduationproject.shareddoctor.Entity.Depart;
import com.graduationproject.shareddoctor.service.DepartService;
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
public class DepartController {

    @Autowired
    DepartService departService;


    @PostMapping("/depart/findDepartByDepartId")
    public ReturnUtil findDepartByDepartId(@RequestBody Depart depart){
        return departService.findDepartByDepartId(depart.getDepartId());
    }

}
