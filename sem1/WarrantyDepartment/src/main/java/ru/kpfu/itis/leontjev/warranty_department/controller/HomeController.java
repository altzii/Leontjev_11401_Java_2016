package ru.kpfu.itis.leontjev.warranty_department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.leontjev.warranty_department.entity.Status;
import ru.kpfu.itis.leontjev.warranty_department.entity.User;
import ru.kpfu.itis.leontjev.warranty_department.service.ClientService;
import ru.kpfu.itis.leontjev.warranty_department.service.OrderService;
import ru.kpfu.itis.leontjev.warranty_department.service.StatusService;
import ru.kpfu.itis.leontjev.warranty_department.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alexander on 17/04/2016.
 */

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    ClientService clientService;

    @Autowired
    StatusService statusService;

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model, HttpServletRequest httpServletRequest) {
        User user = userService.findByLogin(httpServletRequest.getUserPrincipal().getName());

        if (user.getRole().equals("ROLE_USER")) {
            return "redirect:/user/orders";
        }

        int operatorSize = userService.findAllByRole("ROLE_OPERATOR").size();
        int clientSize = clientService.findAll().size();
        Status status = statusService.findByName("В обработке");
        int newOrderSize = orderService.findAllByStatus(status).size();
        int orderSize = orderService.findAll().size();

        model.put("operators_size", operatorSize);
        model.put("clients_size", clientSize);
        model.put("new_orders_size", newOrderSize);
        model.put("orders_size", orderSize);

        return "/home";
    }


}
