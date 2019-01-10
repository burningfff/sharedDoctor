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
public class Doctor {
    @Id
    @GeneratedValue
    @Column(name = "doctor_id")
    public String doctorId;

    @Column(name = "doctor_name")
    public String doctorName;

    @Column(name = "identity_card")
    public Integer identityCard;

    @Column(name = "depart_id")
    public Integer departId;

    @Column(name = "image_url")
    public String image;

    @Column(name = "phone")
    public String phone;

    @Column(name = "email")
    public String email;

    @Column(name = "location_id")
    public Integer locationId;

    @Column(name = "balance_id")
    public Integer balanceId;

    @Column(name = "evaluation")
    public Integer evaluation;

    @Column(name = "is_confirmed")
    public Integer isConfirmed;

    @Column(name = "introduction")
    public String introduction;

}
