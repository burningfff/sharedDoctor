package com.graduationproject.shareddoctor.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;


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
public class OrderForm {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "order_id",length = 32)
    public String orderId;

    @Column(name = "time_id",length = 32)
    public String timeId;

    @Column(name = "patient_id",length = 32)
    public String patientId;

    @OneToOne
    @JoinColumn(name="time_id",referencedColumnName="time_id", insertable=false, updatable=false)
    public Timeslot timeslot;

    @ManyToOne
    @JoinColumn(name="patient_id",referencedColumnName="patient_id", insertable=false, updatable=false)
    public Patient patient;



}
