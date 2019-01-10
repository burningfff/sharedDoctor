package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface IllnessRepository extends JpaRepository<Illness,Integer> {

    Illness findIllnessByIllnessId(Integer illnessId);
    
}
