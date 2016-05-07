package ru.kpfu.itis.leontjev.warranty_department.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.leontjev.warranty_department.entity.User;
import ru.kpfu.itis.leontjev.warranty_department.repository.UserRepository;

/**
 * Created by Alexander on 22/04/2016.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        User user = userRepository.findByLogin(login);
        if (user == null) throw new UsernameNotFoundException("User with name " + login + " not found");
        return new CustomUserDetails(user);
    }
}