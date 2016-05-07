package ru.kpfu.itis.leontjev.warranty_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.leontjev.warranty_department.entity.DeviceType;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {
    List<DeviceType> findAll();
}
