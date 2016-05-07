package ru.kpfu.itis.leontjev.warranty_department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.leontjev.warranty_department.entity.User;
import ru.kpfu.itis.leontjev.warranty_department.repository.UserRepository;
import ru.kpfu.itis.leontjev.warranty_department.service.UserService;

import java.util.List;

/**
 * Created by Alexander on 02/05/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User delete(long id) {
        User user = userRepository.findOne(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User update(User user) {
        return null;
    }

    @Override
    @Transactional
    public User findById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
