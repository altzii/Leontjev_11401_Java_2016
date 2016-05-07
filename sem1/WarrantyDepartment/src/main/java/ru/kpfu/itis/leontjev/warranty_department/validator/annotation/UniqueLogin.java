package ru.kpfu.itis.leontjev.warranty_department.validator.annotation;

import ru.kpfu.itis.leontjev.warranty_department.validator.UniqueLoginValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Alexander on 06/05/2016.
 */
@Documented
@Constraint(validatedBy = UniqueLoginValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueLogin {
    String message() default "Данный логин уже используется";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
