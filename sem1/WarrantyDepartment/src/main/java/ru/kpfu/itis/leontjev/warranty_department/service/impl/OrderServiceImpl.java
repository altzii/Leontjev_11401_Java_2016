package ru.kpfu.itis.leontjev.warranty_department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.leontjev.warranty_department.entity.Order;
import ru.kpfu.itis.leontjev.warranty_department.entity.Status;
import ru.kpfu.itis.leontjev.warranty_department.repository.OrderRepository;
import ru.kpfu.itis.leontjev.warranty_department.service.OrderService;

import java.util.List;

/**
 * Created by Alexander on 08/05/2016.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    @Transactional
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order delete(long id) {
        Order order = orderRepository.findOne(id);
        orderRepository.delete(order);
        return order;
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Order update(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    @Transactional
    public Order findById(long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public List<Order> findAllByStatus(Status status) {
        return orderRepository.findAllByStatus(status);
    }

    @Override
    public List<Order> findAllByOrderByIdAsc() {
        return orderRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<Order> findAllByOrderByIdDesc() {
        return orderRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Order> findAllByOrderByClientNameAsc() {
        return orderRepository.findAllByOrderByClient_NameAsc();
    }

    @Override
    public List<Order> findAllByOrderByClientNameDesc() {
        return orderRepository.findAllByOrderByClient_NameDesc();
    }

    @Override
    public List<Order> findAllByOrderByStatusNameAsc() {
        return orderRepository.findAllByOrderByStatus_NameAsc();
    }

    @Override
    public List<Order> findAllByOrderByStatusNameDesc() {
        return orderRepository.findAllByOrderByStatus_NameDesc();
    }

    @Override
    public List<Order> findAllByClientStatusContaing(String client_Name, String status_Name) {
        return orderRepository.findAllByClient_NameContainingOrStatus_NameContaining(client_Name, status_Name);
    }
}
