package ru.kpfu.itis.leontjev.warranty_department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.leontjev.warranty_department.entity.ServiceCenter;
import ru.kpfu.itis.leontjev.warranty_department.repository.ServiceCenterRepository;
import ru.kpfu.itis.leontjev.warranty_department.service.ServiceCenterService;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
@Service
public class ServiceCenterServiceImpl implements ServiceCenterService {
    @Autowired
    ServiceCenterRepository serviceCenterRepository;

    @Override
    @Transactional
    public ServiceCenter create(ServiceCenter serviceCenter) {
        return serviceCenterRepository.save(serviceCenter);
    }

    @Override
    @Transactional
    public ServiceCenter delete(long id) {
        ServiceCenter serviceCenter = serviceCenterRepository.findOne(id);
        serviceCenterRepository.delete(serviceCenter);
        return serviceCenter;
    }

    @Override
    @Transactional
    public List<ServiceCenter> findAll() {
        return serviceCenterRepository.findAll();
    }

    @Override
    @Transactional
    public ServiceCenter update(ServiceCenter serviceCenter) {
        return null;
    }

    @Override
    @Transactional
    public ServiceCenter findById(long id) {
        return serviceCenterRepository.findOne(id);
    }
}
