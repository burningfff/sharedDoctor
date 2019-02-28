package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


import javax.persistence.*;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/3
 **/
@Getter
@Setter
@Entity
@Component
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    public String doctorId;

    @Column(name = "doctor_name")
    public String doctorName;

    @Column(name = "gender")
    public String gender;

    @Column(name = "identity_card")
    public Integer identityCard;

    @Column(name = "age")
    public Integer age;

    @Column(name = "image_url")
    public String imageUrl;

    @Column(name = "phone")
    public String phone;

    @Column(name = "email")
    public String email;

    @Column(name = "location_id")
    public String locationId;

    @Column(name = "balance_id")
    public String balanceId;

    @Column(name = "evaluation")
    public Integer evaluation;

    @Column(name = "qualification_id")
    public String qualificationId;

    @Column(name = "introduction")
    public String introduction;

    @OneToOne
    @JoinColumn(name="doctor_id",referencedColumnName="user_id")
    public User user;

    @OneToOne
    @JoinColumn(name="location_id",referencedColumnName="location_id", insertable=false, updatable=false)
    public Location location;

    @OneToOne
    @JoinColumn(name="balance_id",referencedColumnName="balance_id", insertable=false, updatable=false)
    public Balance balance;

    @OneToOne
    @JoinColumn(name="qualification_id",referencedColumnName="qualification_id", insertable=false, updatable=false)
    public Qualification qualification;
}
