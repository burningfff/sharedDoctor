package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

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
public class Chat {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "chat_id",length = 32)
    public String chatId;

    @Column(name = "doctor_id")
    public String doctorId;

    @Column(name = "patient_id")
    public String patientId;

    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="chat_id")
    @OrderBy(value = "chat_date ASC,chat_detail_id ASC")
    public List<ChatDetail> chatDetails;

    @ManyToOne
    @JoinColumn(name="doctor_id",referencedColumnName="doctor_id", insertable=false, updatable=false)
    public Doctor doctor;
}
