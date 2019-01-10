package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/


@Getter
@Setter
@Entity
@Component
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Message {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "message_id",length = 32)
    public String messageId;

    @Column(name = "doctor_id")
    public String doctorId;

    @Column(name = "time_id")
    public String timeId;

}
