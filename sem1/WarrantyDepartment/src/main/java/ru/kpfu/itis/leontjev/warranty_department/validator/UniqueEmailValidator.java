package ru.kpfu.itis.leontjev.warranty_department.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.leontjev.warranty_department.entity.User;
import ru.kpfu.itis.leontjev.warranty_department.service.UserService;
import ru.kpfu.itis.leontjev.warranty_department.validator.annotation.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Alexander on 06/05/2016.
 */
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    UserService userService;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email == null) {
            return false;
        }

        User user = userService.findByEmail(email);
        return user == null;
    }
}
