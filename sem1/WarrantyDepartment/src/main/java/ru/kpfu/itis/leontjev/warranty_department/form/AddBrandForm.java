package ru.kpfu.itis.leontjev.warranty_department.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Alexander on 03/05/2016.
 */
public class AddBrandForm {
    @NotEmpty(message = "Введите производителя")
    @Size(max = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
