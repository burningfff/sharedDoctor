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
public class Service {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "service_id",length = 32)
    public String serviceId;

    @Column(name = "doctor_id",length = 32)
    public String doctorId;

    @Column(name = "service_name")
    public String serviceName;

    @Column(name = "price")
    public Double price;

}
