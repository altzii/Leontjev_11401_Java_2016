package ru.kpfu.itis.leontjev.warranty_department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.leontjev.warranty_department.entity.Status;
import ru.kpfu.itis.leontjev.warranty_department.repository.StatusRepository;
import ru.kpfu.itis.leontjev.warranty_department.service.StatusService;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Override
    @Transactional
    public Status create(Status status) {
        return statusRepository.save(status);
    }

    @Override
    @Transactional
    public Status delete(long id) {
        Status status = statusRepository.findOne(id);
        statusRepository.delete(status);
        return status;
    }

    @Override
    @Transactional
    public List<Status> findAll() {
        return statusRepository.findAll();
    }


    @Override
    @Transactional
    public Status update(Status status) {
        return null;
    }

    @Override
    @Transactional
    public Status findById(long id) {
        return statusRepository.findOne(id);
    }
}
