package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.ChatDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/4/17
 **/
public interface ChatDetailRepository extends JpaRepository<ChatDetail,String> {

    List<ChatDetail> findAllByChatId (String ChatId);

}
