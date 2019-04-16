package com.graduationproject.shareddoctor.service;

import com.graduationproject.shareddoctor.utils.ReturnUtil;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/10
 **/

public interface LocationService {
    //根据id查找Location
    ReturnUtil findLocationByLocationId(String locationId);

    //修改地址
    ReturnUtil updateLocationByLocationId(String province,String city,String area,String locationDetail,String areaCode,String locationId);

    //新增地址
    ReturnUtil addLocation(String province,String city,String area,String areaCode,String locationDetail);

}

