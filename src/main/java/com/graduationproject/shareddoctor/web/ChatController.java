package com.graduationproject.shareddoctor.web;

import com.graduationproject.shareddoctor.Entity.Chat;
import com.graduationproject.shareddoctor.service.ChatService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/4/23
 **/

@CrossOrigin
@RestController
public class ChatController {

    @Autowired
    ChatService chatService;

    @PostMapping("/chat/findAllByPatientId")
    public ReturnUtil findAllByPatientId(@RequestBody Chat chat){
        return chatService.findAllByPatientId(chat.getPatientId());
    }

    @PostMapping("/chat/findAllByDoctorId")
    public ReturnUtil findAllByDoctorId(@RequestBody Chat chat){
        return chatService.findAllByDoctorId(chat.getDoctorId());
    }

    @PostMapping("/chat/addChat")
    public ReturnUtil addChat(@RequestBody Chat chat){
        return chatService.addChat(chat.getPatientId(),chat.getDoctorId());
    }

    @PostMapping("/chat/deleteChatByChatId")
    public ReturnUtil deleteChatByChatId(@RequestBody Chat chat){
        return chatService.deleteChatByChatId(chat.getChatId());
    }

}
