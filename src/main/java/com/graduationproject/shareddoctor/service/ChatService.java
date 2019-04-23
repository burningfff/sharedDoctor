package com.graduationproject.shareddoctor.service;

import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/4/23
 **/
public interface ChatService {

    ReturnUtil findAllByPatientId(String patientId);

    ReturnUtil findAllByDoctorId(String doctorId);

    ReturnUtil addChat(String patientId,String doctorId);

    ReturnUtil deleteChatByChatId(String chatId);
}
