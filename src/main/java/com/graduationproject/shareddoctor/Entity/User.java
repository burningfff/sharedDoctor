package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Create by cy on 2018/6/12
 */

@Getter
@Setter
@Entity
@Component
public class User {

    @Id
    @GeneratedValue
//    @Column(name = "user_id")
    public String userId;

//    @Column(name = "user_name")
    public String userName;

//    @Column(name = "password")
    public String password;

//    @Column(name = "identity")
    public Integer identity;

//    @Column(name = "create_date")
    public Date createDate;

}
