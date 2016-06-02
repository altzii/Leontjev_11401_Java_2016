package ru.kpfu.itis.leontjev.warranty_department.service;

import ru.kpfu.itis.leontjev.warranty_department.entity.Order;
import ru.kpfu.itis.leontjev.warranty_department.entity.Status;

import java.util.List;

/**
 * Created by Alexander on 07/05/2016.
 */
public interface OrderService {
    Order create(Order order);

    Order delete(long id);

    List<Order> findAll();

    Order update(Order order);

    Order findById(long id);

    List<Order> findAllByStatus(Status status);

    List<Order> findAllByOrderByIdAsc();

    List<Order> findAllByOrderByIdDesc();

    List<Order> findAllByOrderByClientNameAsc();

    List<Order> findAllByOrderByClientNameDesc();

    List<Order> findAllByOrderByStatusNameAsc();

    List<Order> findAllByOrderByStatusNameDesc();

    List<Order> findAllByClientStatusContaing(String client_Name, String status_Name);
}
