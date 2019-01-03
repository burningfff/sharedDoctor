package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    public String id;

    @Column(nullable=false)
    public String userName;

    @Column(nullable=false)
    public String password;

    public Integer identity;


}
