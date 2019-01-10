package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;


/**
 * Create by cy on 2018/6/12
 */

@Getter
@Setter
@Entity
@Component
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "user_id",length = 32)
    public String userId;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "password")
    public String password;

    @Column(name = "identity")
    public Integer identity;

    @Column(name = "create_date")
    public Date createDate;

}
