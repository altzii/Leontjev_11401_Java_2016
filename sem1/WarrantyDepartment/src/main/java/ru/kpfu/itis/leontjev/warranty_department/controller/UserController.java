package ru.kpfu.itis.leontjev.warranty_department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.leontjev.warranty_department.entity.Client;
import ru.kpfu.itis.leontjev.warranty_department.entity.User;
import ru.kpfu.itis.leontjev.warranty_department.form.AddUserForm;
import ru.kpfu.itis.leontjev.warranty_department.form.ChangeProfileForm;
import ru.kpfu.itis.leontjev.warranty_department.service.ClientService;
import ru.kpfu.itis.leontjev.warranty_department.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Alexander on 05/05/2016.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        User user = userService.findByLogin(login);
        model.put("user", user);
        model.addAttribute("profile_form", new ChangeProfileForm());

        return "/profile";
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.POST)
    public String updateProfile(HttpServletRequest httpServletRequest, ModelMap model, @ModelAttribute("profile_form") @Valid ChangeProfileForm form, BindingResult result) {
        User user = userService.findByLogin(httpServletRequest.getUserPrincipal().getName());
        if (result.hasErrors()) {
            model.put("user", user);
            return "/profile";
        }

        String name = form.getName();
        String address = form.getAddress();
        String phone = form.getPhone();

        Client client = user.getClient();
        client.setName(name);
        client.setAddress(address);
        client.setPhone(phone);

        clientService.update(client);

        return "redirect:/profile";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String serviceCenters(ModelMap model) {
        model.put("users", userService.findAll());
        return "/users";
    }

    @RequestMapping(value = "/admin/delete/users/{id:\\d+}", method = RequestMethod.POST)
    public String deleteServiceCenter(@PathVariable String id) {
        userService.delete(Integer.parseInt(id));
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addServiceCenterPage(Model model) {
        model.addAttribute("user_form", new AddUserForm());
        return "/add_user";
    }

    @RequestMapping(value = "admin/users/add", method = RequestMethod.POST)
    public String addStatus(@ModelAttribute("user_form") @Valid AddUserForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/add_user";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = new User();

        String login = form.getLogin();
        String email = form.getEmail();
        String password = passwordEncoder.encode(form.getPassword());
        String role = form.getRole();

        user.setLogin(login);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        userService.create(user);

        return "redirect:/admin/users/";
    }

}
