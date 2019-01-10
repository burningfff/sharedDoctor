package com.graduationproject.shareddoctor.service.Impl;

import com.graduationproject.shareddoctor.Entity.Location;
import com.graduationproject.shareddoctor.respository.LocationRepository;
import com.graduationproject.shareddoctor.service.LocationService;
import com.graduationproject.shareddoctor.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 * Create by cy on 2018/6/13
 */
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
}
