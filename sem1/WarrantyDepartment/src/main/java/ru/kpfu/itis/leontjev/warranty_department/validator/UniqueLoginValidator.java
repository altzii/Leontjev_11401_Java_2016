package ru.kpfu.itis.leontjev.warranty_department.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.leontjev.warranty_department.entity.User;
import ru.kpfu.itis.leontjev.warranty_department.service.UserService;
import ru.kpfu.itis.leontjev.warranty_department.validator.annotation.UniqueLogin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Alexander on 06/05/2016.
 */
@Component
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {
    @Autowired
    UserService userService;

    @Override
    public void initialize(UniqueLogin uniqueLogin) {
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        if (login == null) {
            return false;
        }

        User user = userService.findByLogin(login);
        return user == null;
    }
}