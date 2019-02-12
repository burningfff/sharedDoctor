package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Message;
import com.graduationproject.shareddoctor.respository.MessageRepository;
import com.graduationproject.shareddoctor.service.MessageService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public ReturnUtil findMessageByMessageId(String messageId) {
        Message message=messageRepository.findMessageByMessageId(messageId);
        return ReturnUtil.ok(message);
    }
}
