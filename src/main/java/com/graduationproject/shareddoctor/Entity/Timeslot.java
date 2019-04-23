package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
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
public class Timeslot {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "time_id",length = 32)
    public String timeId;

    @Column(name = "doctor_id")
    public String doctorId;

    @Column(name = "start_time")
    public Date startTime;

    @Column(name = "end_time")
    public Date endTime;

    @Column(name = "is_ordered")
    public Integer isOrdered;

    @Column(name = "service_id")
    public String serviceId;

    @Column(name = "service_type")
    public Integer serviceType;

    @ManyToOne
    @JoinColumn(name="service_id",referencedColumnName="service_id", insertable=false, updatable=false)
    public Service service;

    @ManyToOne
    @JoinColumn(name="doctor_id",referencedColumnName="doctor_id", insertable=false, updatable=false)
    public Doctor doctor;
}
