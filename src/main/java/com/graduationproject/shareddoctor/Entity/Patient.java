package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    public Integer gender;

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

    @Column(name = "illness_id")
    public String illnessId;

}
