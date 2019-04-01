package com.graduationproject.shareddoctor.web;


import com.graduationproject.shareddoctor.Entity.Illness;
import com.graduationproject.shareddoctor.service.IllnessService;
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
public class IllnessController {

    @Autowired
    IllnessService illnessService;


    @PostMapping("/illness/findIllnessByIllnessId")
    public ReturnUtil findIllnessByIllnessId(@RequestBody Illness illness){
        return illnessService.findIllnessByIllnessId(illness.getIllnessId());
    }

    @PostMapping("/illness/findAllByIllnessNameContaining")
    public ReturnUtil findAllByIllnessNameContaining(@RequestBody Illness illness){
        return illnessService.findAllByIllnessNameContaining(illness.getIllnessName());
    }

}
