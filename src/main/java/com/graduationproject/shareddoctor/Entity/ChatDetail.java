package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/4/17
 **/
@Getter
@Setter
@Entity
@Component
public class ChatDetail {
    @Id
    @Column(name = "chat_id")
    public String chatId;

    @Column(name = "chat_detail")
    public String chatDetail;

    @Column(name = "chat_date")
    public Date chatDate;

}
