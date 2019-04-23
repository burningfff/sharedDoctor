package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
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
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class ChatDetail {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "chat_detail_id",length = 32)
    public String chatDetailId;

    @Column(name = "chat_id",length = 32)
    public String chatId;

    @Column(name = "chat_detail")
    public String chatDetail;

    @Column(name = "chat_date")
    public Date chatDate;

}
