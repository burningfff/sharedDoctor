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
 * @create: 2019/1/10
 **/


@Getter
@Setter
@Entity
@Component
public class Balance {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "balance_id",length = 32)
    public String balanceId;

    @Column(name = "balance")
    public Double balance;

}
