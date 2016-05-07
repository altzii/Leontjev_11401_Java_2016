package ru.kpfu.itis.leontjev.warranty_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.leontjev.warranty_department.entity.ServiceCenter;

import java.util.List;

/**
 * Created by Alexander on 02/05/2016.
 */
@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {
    List<ServiceCenter> findAll();
}
