package com.graduationproject.shareddoctor.web;


import com.graduationproject.shareddoctor.Entity.Depart;
import com.graduationproject.shareddoctor.service.DepartService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/depart/findDepart")
    public ReturnUtil findDepartByDepartName(@RequestBody Depart depart){
        return departService.findDepartByDepartName(depart.getDepartName());
    }
    @PostMapping("/depart/addDepart")
    public ReturnUtil addDepart (@RequestBody Depart depart){
        return departService.addDepart(depart.getDepartName());
    }

    @PostMapping("/depart/deleteDepart")
    public ReturnUtil deleteDepart (@RequestBody Depart depart){
        //不使用该接口即不能通过前端请求删除院系
        return departService.deleteDepart(depart.getDepartId());
    }

    @PostMapping("/depart/updateDepart")
    public ReturnUtil updateDepart (@RequestBody Depart depart){
        return departService.updateDepart(depart.getDepartName(),depart.getDepartId());
    }

    @PostMapping("/depart/findAll")
    public ReturnUtil findAllDepart(){
        return departService.findAllDepart();
    }

    @PostMapping("/depart/findIdByName")
    public ReturnUtil findDepartIdByDepartName(@RequestBody Depart depart){
        return departService.findDepartIdByDepartName(depart.getDepartName());
    }

//
//    @PostMapping("/depart/addFromExcel")
//    public ReturnUtil addFromExcel(@RequestParam MultipartFile file) throws Exception {
//        return departService.addFromExcel(file);
//    }
}
