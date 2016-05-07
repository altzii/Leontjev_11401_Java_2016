package ru.kpfu.itis.leontjev.warranty_department.service;

import ru.kpfu.itis.leontjev.warranty_department.entity.ServiceCenter;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
public interface ServiceCenterService {
    ServiceCenter create(ServiceCenter serviceCenter);
    ServiceCenter delete(long id);
    List<ServiceCenter> findAll();
    ServiceCenter update(ServiceCenter serviceCenter);
    ServiceCenter findById(long id);
}


