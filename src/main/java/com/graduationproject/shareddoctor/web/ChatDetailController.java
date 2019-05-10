package com.graduationproject.shareddoctor.web;

import com.graduationproject.shareddoctor.Entity.ChatDetail;
import com.graduationproject.shareddoctor.service.ChatDetailService;
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
public class ChatDetailController {
    @Autowired
    ChatDetailService chatDetailService;

    @PostMapping("/chatDetail/findAllByChatId")
    public ReturnUtil findAllByChatId(@RequestBody ChatDetail chatDetail){
        return chatDetailService.findAllByChatId(chatDetail.getChatId());
    }

    @PostMapping("/chatDetail/deleteAllChatDetailByChatId")
    public ReturnUtil deleteAllChatDetailByChatId(@RequestBody ChatDetail chatDetail){
        return chatDetailService.deleteAllChatDetailByChatId(chatDetail.getChatId());
    }

    @PostMapping("/chatDetail/addChatDetail")
    public ReturnUtil addChatDetail(@RequestBody ChatDetail chatDetail){
        return chatDetailService.addChatDetail(chatDetail.getChatId(),chatDetail.getChatDetail());
    }

}
