package com.graduationproject.shareddoctor.web;

import com.graduationproject.shareddoctor.service.AddImageService;
import com.graduationproject.shareddoctor.service.BalanceService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/5/7
 **/
@CrossOrigin
@RestController
public class AddImageController {

    @Autowired
    AddImageService addImageService;

    @RequestMapping("/addImage")
    public ReturnUtil addImage(@RequestParam(name = "image_data", required = false) MultipartFile file) {
        //文件上传
        return addImageService.addImage(file);
    }
}
