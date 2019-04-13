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
public class Patient {
    @Id
    @Column(name = "patient_id")
    public String patientId;

    @Column(name = "patient_name")
    public String patientName;

    @Column(name = "gender")
    public String gender;

    @Column(name = "identity_card")
    public String identityCard;

    @Column(name = "age")
    public Integer age;

    @Column(name= "weight")
    public Integer weight;

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

    @Column(name = "illness")
    public String illness;

    @OneToOne
    @JoinColumn(name="patient_id",referencedColumnName="user_id")
    public User user;

    @OneToOne
    @JoinColumn(name="location_id",referencedColumnName="location_id", insertable=false, updatable=false)
    public Location location;

    @OneToOne
    @JoinColumn(name="balance_id",referencedColumnName="balance_id", insertable=false, updatable=false)
    public Balance balance;

}
