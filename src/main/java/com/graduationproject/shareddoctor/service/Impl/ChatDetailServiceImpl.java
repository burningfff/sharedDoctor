package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.ChatDetail;
import com.graduationproject.shareddoctor.respository.ChatDetailRepository;
import com.graduationproject.shareddoctor.service.ChatDetailService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/4/23
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class ChatDetailServiceImpl implements ChatDetailService {
    @Autowired
    ChatDetailRepository chatDetailRepository;

    @Override
    public ReturnUtil findAllByChatId (String chatId){
        return ReturnUtil.ok(chatDetailRepository.findAllByChatId(chatId));
    }

    @Override
    public ReturnUtil addChatDetail(String chatId, String chatDetail){
        ChatDetail chatDetail1=new ChatDetail();
        chatDetail1.setChatDetail(chatDetail);
        chatDetail1.setChatId(chatId);
        chatDetail1.setChatDate(new Date());
        chatDetailRepository.save(chatDetail1);
        return ReturnUtil.ok(chatDetail1);
    }

    @Override
    public ReturnUtil deleteChatDetailByChatId(String chatId){
        chatDetailRepository.deleteChatDetailByChatId(chatId);
        return ReturnUtil.ok("删除成功！");
    }
}
