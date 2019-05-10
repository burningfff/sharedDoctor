package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
public interface ServiceRepository extends JpaRepository<Service,String> {

    Service findServiceByServiceId(String serviceId);

    void deleteServiceByServiceId(String serviceId);

    List<Service> findAllByDoctorId(String doctorId);
}
