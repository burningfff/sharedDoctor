package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Chat;
import com.graduationproject.shareddoctor.respository.ChatRepository;
import com.graduationproject.shareddoctor.service.ChatService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/4/23
 **/

@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    ChatRepository chatRepository;

    @Override
    public com.graduationproject.shareddoctor.utils.ReturnUtil findAllByPatientId(String patientId){
        return  ReturnUtil.ok(chatRepository.findAllByPatientId(patientId));
    }

    @Override
    public ReturnUtil findAllByDoctorId(String doctorId){
        return  ReturnUtil.ok(chatRepository.findAllByDoctorId(doctorId));

    }

    @Override
    public ReturnUtil addChat(String patientId,String doctorId){
        Chat chat=new Chat();
        chat.setDoctorId(doctorId);
        chat.setPatientId(patientId);
        chatRepository.save(chat);
        return ReturnUtil.ok(chat);
    }

    @Override
    public ReturnUtil deleteChatByChatId(String chatId){
        chatRepository.deleteChatByChatId(chatId);
        return ReturnUtil.ok("删除成功！");
    }
}
