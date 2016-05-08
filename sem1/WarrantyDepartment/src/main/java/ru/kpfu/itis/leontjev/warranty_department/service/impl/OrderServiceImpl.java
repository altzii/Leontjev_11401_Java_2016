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
}
