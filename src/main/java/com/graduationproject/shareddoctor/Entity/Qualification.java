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
public class Qualification {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "qualification_id",length = 32)
    public String qualificationId;

    @Column(name = "depart_id")
    public Integer departId;

    @Column(name = "image_url")
    public String imageUrl;

    @Column(name = "position_id")
    public Integer positionId;

    @Column(name = "hospital_id")
    public Integer hospitalId;

    @Column(name = "is_confirmed")
    public Integer isConfirmed;

    @ManyToOne
    @JoinColumn(name="depart_id",referencedColumnName="depart_id", insertable=false, updatable=false)
    public Depart depart;

    @ManyToOne
    @JoinColumn(name="position_id",referencedColumnName="position_id", insertable=false, updatable=false)
    public Position position;

    @ManyToOne
    @JoinColumn(name="hospital_id",referencedColumnName="hospital_id", insertable=false, updatable=false)
    public Hospital hospital;

}
