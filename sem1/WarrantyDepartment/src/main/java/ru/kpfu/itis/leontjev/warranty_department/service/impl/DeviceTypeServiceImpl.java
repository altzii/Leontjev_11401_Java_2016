package ru.kpfu.itis.leontjev.warranty_department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.leontjev.warranty_department.entity.DeviceType;
import ru.kpfu.itis.leontjev.warranty_department.repository.DeviceTypeRepository;
import ru.kpfu.itis.leontjev.warranty_department.service.DeviceTypeService;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeRepository deviceTypeRepository;

    @Override
    @Transactional
    public DeviceType create(DeviceType deviceType) {
        return deviceTypeRepository.save(deviceType);
    }

    @Override
    @Transactional
    public DeviceType delete(long id) {
        DeviceType deviceType = deviceTypeRepository.findOne(id);
        deviceTypeRepository.delete(deviceType);
        return deviceType;
    }

    @Override
    @Transactional
    public List<DeviceType> findAll() {
        return deviceTypeRepository.findAll();
    }

    @Override
    @Transactional
    public DeviceType update(DeviceType deviceType) {
        return null;
    }

    @Override
    @Transactional
    public DeviceType findById(long id) {
        return deviceTypeRepository.findOne(id);
    }
}
