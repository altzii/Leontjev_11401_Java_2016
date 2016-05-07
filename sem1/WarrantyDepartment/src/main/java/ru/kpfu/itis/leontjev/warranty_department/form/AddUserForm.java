package ru.kpfu.itis.leontjev.warranty_department.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.leontjev.warranty_department.validator.annotation.UniqueEmail;
import ru.kpfu.itis.leontjev.warranty_department.validator.annotation.UniqueLogin;

import javax.validation.constraints.Size;

/**
 * Created by Alexander on 05/05/2016.
 */
public class AddUserForm {
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

    @NotEmpty(message = "Введите роль")
    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
