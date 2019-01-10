package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface PositionRepository extends JpaRepository<Position,Integer> {

    Position findPositionByPositionId(Integer positionId);
    
}
