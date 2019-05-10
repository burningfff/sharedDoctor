package com.graduationproject.shareddoctor.service;

import com.graduationproject.shareddoctor.utils.ReturnUtil;

import java.util.Date;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/4/23
 **/
public interface ChatDetailService {

    ReturnUtil findAllByChatId (String chatId);

    ReturnUtil addChatDetail(String chatId, String chatDetail);

    ReturnUtil deleteAllChatDetailByChatId(String chatId);
}
