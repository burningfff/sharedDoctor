package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface LocationRepository extends JpaRepository<Location,String> {

    Location findLocationByLocationId(String locationId);
    
}
