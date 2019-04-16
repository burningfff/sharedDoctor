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
public class Location {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "location_id",length = 32)
    public String locationId;

    @Column(name = "province")
    public String province;

    @Column(name = "city")
    public String city;

    @Column(name = "area")
    public String area;

    @Column(name = "area_code")
    public String areaCode;

    @Column(name = "location_detail")
    public String locationDetail;

}
