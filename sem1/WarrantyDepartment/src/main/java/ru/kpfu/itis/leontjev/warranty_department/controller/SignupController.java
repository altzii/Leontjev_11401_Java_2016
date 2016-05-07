package ru.kpfu.itis.leontjev.warranty_department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.leontjev.warranty_department.entity.Client;
import ru.kpfu.itis.leontjev.warranty_department.entity.User;
import ru.kpfu.itis.leontjev.warranty_department.form.SignupForm;
import ru.kpfu.itis.leontjev.warranty_department.service.ClientService;
import ru.kpfu.itis.leontjev.warranty_department.service.UserService;

import javax.validation.Valid;

/**
 * Created by Alexander on 02/05/2016.
 */
@Controller
public class SignupController {
    @Autowired
    UserService userService;
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignup(Model model) {

        model.addAttribute("signup_form", new SignupForm());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute("signup_form") @Valid SignupForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "signup";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String login = form.getLogin();
        String email = form.getEmail();
        String password = passwordEncoder.encode(form.getPassword());
        String role = form.getRole();
        String name = form.getName();
        String address = form.getAddress();
        String phone = form.getPhone();

        Client client = new Client();
        client.setName(name);
        client.setAddress(address);
        client.setPhone(phone);

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(role);
        user.setClient(client);


        clientService.create(client);
        userService.create(user);
        user = userService.findByLogin(user.getLogin());
        client.setUser(user);
        clientService.update(client);

        return "redirect:/signin?from_signup=1";
    }
}
