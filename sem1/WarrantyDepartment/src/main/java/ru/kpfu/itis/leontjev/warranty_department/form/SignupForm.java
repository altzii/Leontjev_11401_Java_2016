package ru.kpfu.itis.leontjev.warranty_department.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.leontjev.warranty_department.validator.annotation.ConfirmingPassword;
import ru.kpfu.itis.leontjev.warranty_department.validator.annotation.UniqueEmail;
import ru.kpfu.itis.leontjev.warranty_department.validator.annotation.UniqueLogin;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Alexander on 02/05/2016.
 */
@ConfirmingPassword(password = "password", confirmPassword = "confirmPassword")
public class SignupForm {
    @Size(min = 3, max = 40, message = "Логин должен быть от 3 до 40 символов")
    @NotEmpty(message = "Поле не должно быть пустым")
    @UniqueLogin
    private String login;

    @Email(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Некорректный email")
    @NotEmpty(message = "Поле не должно быть пустым")
    @UniqueEmail
    private String email;

    @Size(min = 3, max = 100, message = "Пароль должен быть от 3 до 100 символов")
    @NotEmpty(message = "Введите пароль")
    private String password;

    @Size(min = 3, max = 100, message = "Пароль должен быть от 3 до 100 символов")
    @NotEmpty(message = "Подтвердите пароль")
    private String confirmPassword;

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

    public String getRole() {
        return "ROLE_USER";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
