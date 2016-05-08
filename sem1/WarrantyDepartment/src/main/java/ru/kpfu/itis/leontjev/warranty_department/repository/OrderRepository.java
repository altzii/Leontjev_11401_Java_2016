package ru.kpfu.itis.leontjev.warranty_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.leontjev.warranty_department.entity.Order;
import ru.kpfu.itis.leontjev.warranty_department.entity.Status;

import java.util.List;

/**
 * Created by Alexander on 08/05/2016.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long > {
    List<Order> findAll();
    List<Order> findAllByStatus(Status status);
}
