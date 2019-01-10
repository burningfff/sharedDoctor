package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface MessageRepository extends JpaRepository<Message,String> {

    Message findMessageByMessageId(String messageId);
    
}
