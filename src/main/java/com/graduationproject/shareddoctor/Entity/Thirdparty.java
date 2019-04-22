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
 * @create: 2019/4/17
 **/
@Getter
@Setter
@Entity
@Component
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Thirdparty {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "thirdparty_id",length = 32)
    public String thirdpartyId;

    @Column(name = "order_id")
    public String orderId;

    @Column(name = "create_date")
    public Date createDate;

    @OneToOne
    @JoinColumn(name="order_id",referencedColumnName="order_id", insertable=false, updatable=false)
    public OrderForm orderForm;

}
