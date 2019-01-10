package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


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
public class Hospital {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "hospital_id",length = 32)
    public String hospitalId;

    @Column(name = "hospital_name")
    public String hospitalName;

    @Column(name = "hospital_level")
    public String hospitalLevel;

    @Column(name = "location_id")
    public String locationId;

}
