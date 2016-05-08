package ru.kpfu.itis.leontjev.warranty_department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.leontjev.warranty_department.entity.Client;
import ru.kpfu.itis.leontjev.warranty_department.form.AddClientForm;
import ru.kpfu.itis.leontjev.warranty_department.service.ClientService;

import javax.validation.Valid;

/**
 * Created by Alexander on 08/05/2016.
 */
@Controller
public class ClientController {
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/operator/clients", method = RequestMethod.GET)
    public String clients(ModelMap model) {
        model.put("clients", clientService.findAll());
        return "/clients";
    }

    @RequestMapping(value = "/operator/delete/clients/{id:\\d+}", method = RequestMethod.POST)
    public String deleteClient(@PathVariable String id) {
        clientService.delete(Integer.parseInt(id));
        return "redirect:/operator/clients";
    }

    @RequestMapping(value = "/operator/clients/add", method = RequestMethod.GET)
    public String addClient(Model model) {
        model.addAttribute("client_form", new AddClientForm());
        return "/add_client";
    }

    @RequestMapping(value = "operator/clients/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("client_form") @Valid AddClientForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/add_client";
        }

        Client client = new Client();

        String name = form.getName();
        String phone = form.getPhone();
        String address = form.getAddress();

        client.setName(name);
        client.setPhone(phone);
        client.setAddress(address);

        clientService.create(client);

        return "redirect:/operator/clients";

    }
}
