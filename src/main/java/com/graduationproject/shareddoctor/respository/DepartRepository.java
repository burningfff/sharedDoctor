package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface DepartRepository extends JpaRepository<Depart,Integer> {

    Depart findDepartByDepartId(Integer departId);

    Depart findDepartByDepartName(String departName);

    List<Depart> findAllByDepartNameContaining(String departName);

}
