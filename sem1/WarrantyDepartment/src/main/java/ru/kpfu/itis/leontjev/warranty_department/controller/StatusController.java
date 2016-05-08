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
import ru.kpfu.itis.leontjev.warranty_department.entity.Status;
import ru.kpfu.itis.leontjev.warranty_department.form.AddStatusForm;
import ru.kpfu.itis.leontjev.warranty_department.service.StatusService;

import javax.validation.Valid;

/**
 * Created by Alexander on 03/05/2016.
 */
@Controller
public class StatusController {
    @Autowired
    StatusService statusService;

    @RequestMapping(value = "/operator/statuses", method = RequestMethod.GET)
    public String statuses(ModelMap model) {
        model.put("statuses", statusService.findAll());
        return "/statuses";
    }

    @RequestMapping(value = "/operator/delete/statuses/{id:\\d+}", method = RequestMethod.POST)
    public String deleteStatus(@PathVariable String id) {
        statusService.delete(Integer.parseInt(id));
        return "redirect:/operator/statuses";
    }


    @RequestMapping(value = "/operator/statuses/add", method = RequestMethod.GET)
    public String addStatusPage(Model model) {
        model.addAttribute("status_form", new AddStatusForm());
        return "/add_status";
    }

    @RequestMapping(value = "operator/statuses/add", method = RequestMethod.POST)
    public String addStatus(@ModelAttribute("status_form") @Valid AddStatusForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/add_status";
        }

        String name = form.getName();
        Status status = new Status();
        status.setName(name);

        statusService.create(status);

        return "redirect:/operator/statuses/";
    }
}
