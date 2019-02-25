package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface DepartRepository extends JpaRepository<Depart,Integer> {

    Depart findDepartByDepartId(Integer departId);

    Depart findDepartByDepartName(String departName);



}
