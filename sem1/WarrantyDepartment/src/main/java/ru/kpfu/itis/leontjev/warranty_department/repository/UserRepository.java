package ru.kpfu.itis.leontjev.warranty_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.leontjev.warranty_department.entity.User;

import java.util.List;

/**
 * Created by Alexander on 02/05/2016.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByLogin(String login);

    User findByEmail(String email);
}
