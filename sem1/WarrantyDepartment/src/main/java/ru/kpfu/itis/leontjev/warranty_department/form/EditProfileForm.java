package ru.kpfu.itis.leontjev.warranty_department.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Alexander on 07/05/2016.
 */
public class EditProfileForm {
    @Size(max = 100, message = "Максимальная длина - 100 символов")
    @NotEmpty(message = "Поле не должно быть пустым")
    private String name;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(max = 100, message = "Максимальная длина - 100 символов")
    @Pattern(regexp = "^( +)?((\\+?7|8) ?)?((\\(\\d{3}\\))|(\\d{3}))?( )?(\\d{3}[\\- ]?\\d{2}[\\- ]?\\d{2})( +)?$", message = "Некорректный формат номера телефона")
    private String phone;

    @Size(max = 100, message = "Максимальная длина - 150 символов")
    @NotEmpty(message = "Поле не должно быть пустым")
    private String address;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}