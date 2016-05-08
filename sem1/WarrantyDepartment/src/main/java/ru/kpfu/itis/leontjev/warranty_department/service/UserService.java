package ru.kpfu.itis.leontjev.warranty_department.service;

import ru.kpfu.itis.leontjev.warranty_department.entity.User;

import java.util.List;

/**
 * Created by Alexander on 22/04/2016.
 */
public interface UserService {
    User create(User user);

    User delete(long id);

    List<User> findAll();

    User update(User user);

    User findById(long id);

    User findByLogin(String login);

    User findByEmail(String email);

    List<User> findAllByRole(String role);
}
