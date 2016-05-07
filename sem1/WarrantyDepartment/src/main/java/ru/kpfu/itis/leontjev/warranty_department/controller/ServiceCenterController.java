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
import ru.kpfu.itis.leontjev.warranty_department.entity.ServiceCenter;
import ru.kpfu.itis.leontjev.warranty_department.form.AddServiceCenterForm;
import ru.kpfu.itis.leontjev.warranty_department.service.ServiceCenterService;

import javax.validation.Valid;

/**
 * Created by Alexander on 03/05/2016.
 */
@Controller
public class ServiceCenterController {
    @Autowired
    ServiceCenterService serviceCenterService;

    @RequestMapping(value = "/operator/service_centers", method = RequestMethod.GET)
    public String serviceCenters(ModelMap model) {
        model.put("service_centers", serviceCenterService.findAll());
        return "/service_centers";
    }

    @RequestMapping(value = "/operator/delete/service_centers/{id:\\d+}", method = RequestMethod.POST)
    public String deleteServiceCenter(@PathVariable String id) {
        serviceCenterService.delete(Integer.parseInt(id));
        return "redirect:/operator/service_centers";
    }

    @RequestMapping(value = "/operator/service_centers/add", method = RequestMethod.GET)
    public String addServiceCenterPage(Model model) {
        model.addAttribute("service_center_form", new AddServiceCenterForm());
        return "/add_service_center";
    }

    @RequestMapping(value = "operator/service_centers/add", method = RequestMethod.POST)
    public String addServiceCenter(@ModelAttribute("service_center_form") @Valid AddServiceCenterForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/operator/service_centers/add";
        }

        String name = form.getName();
        String phone = form.getPhone();
        String address = form.getAddress();

        ServiceCenter serviceCenter = new ServiceCenter();
        serviceCenter.setName(name);
        serviceCenter.setPhone(phone);
        serviceCenter.setAddress(address);

        serviceCenterService.create(serviceCenter);

        return "redirect:/operator/service_centers/";
    }
}
