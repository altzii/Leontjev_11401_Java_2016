package ru.kpfu.itis.leontjev.warranty_department.service;

import ru.kpfu.itis.leontjev.warranty_department.entity.DeviceType;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
public interface DeviceTypeService {
    DeviceType create(DeviceType deviceType);
    DeviceType delete(long id);
    List<DeviceType> findAll();
    DeviceType update(DeviceType deviceType);
    DeviceType findById(long id);
}
