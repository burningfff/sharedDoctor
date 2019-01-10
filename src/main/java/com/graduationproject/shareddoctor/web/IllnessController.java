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
 * Create by cy on 2018/6/13
 */

@CrossOrigin
@RestController
public class IllnessController {

    @Autowired
    IllnessService illnessService;


    @PostMapping("/illness/findIllnessByIllnessId")
    public ReturnUtil findIllnessByIllnessId(@RequestBody Illness illness){
        return illnessService.findIllnessByIllnessId(illness.getIllnessId());
    }

}
