package ru.kpfu.itis.leontjev.warranty_department.service;

import ru.kpfu.itis.leontjev.warranty_department.entity.Status;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
public interface StatusService {
    Status create(Status status);
    Status delete(long id);
    List<Status> findAll();
    Status update(Status status);
    Status findById(long id);
}
