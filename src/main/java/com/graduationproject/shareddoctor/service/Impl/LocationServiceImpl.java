package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Location;
import com.graduationproject.shareddoctor.respository.LocationRepository;
import com.graduationproject.shareddoctor.service.LocationService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/
@ComponentScan(basePackages="com.graduationproject.shareddoctor")
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public ReturnUtil findLocationByLocationId(String locationId) {
        Location location=locationRepository.findLocationByLocationId(locationId);
        return ReturnUtil.ok(location);
    }

//    @Override
//    public ReturnUtil updateLocationByLocationId(String province,String city,String district,String locationDetail,String locationId){
//        Location location = locationRepository.findLocationByLocationId(locationId);
//        location.setProvince(province);
//        location.setCity(city);
//        location.setDistrict(district);
//        location.setLocationDetail(locationDetail);
//        locationRepository.save(location);
//        System.out.println(location.locationId);
//        return ReturnUtil.ok();
//    }

    @Override
    public ReturnUtil addLocation(String province,String city,String district,String locationDetail){
        Location location = new Location();
        location.setProvince(province);
        location.setCity(city);
        location.setDistrict(district);
        location.setLocationDetail(locationDetail);
        locationRepository.save(location);
        System.out.println(location.locationId);
        return ReturnUtil.ok();
    }

}
