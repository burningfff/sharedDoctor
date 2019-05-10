package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Balance;
import com.graduationproject.shareddoctor.service.AddImageService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/5/7
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class AddImageServiceImpl implements AddImageService {
    public ReturnUtil addImage(MultipartFile file) {
        if (!file.isEmpty()) {
            File newFile;
            try {
                //图片命名
                String newCompanyImageName = System.currentTimeMillis() + file.getOriginalFilename();
                String newCompanyImagepath = "http://106.14.137.163:22/graduationProject/uploader" + newCompanyImageName;
                newFile = new File(newCompanyImagepath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return ReturnUtil.err("图片上传失败！" + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                return ReturnUtil.err("图片上传失败！" + e.getMessage());
            }
            return ReturnUtil.ok(newFile);
        }
        return ReturnUtil.err("图片上传失败！");
    }
}
