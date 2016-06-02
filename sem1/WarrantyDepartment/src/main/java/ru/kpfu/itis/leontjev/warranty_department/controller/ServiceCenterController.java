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
            return "/add_service_center";
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

    @RequestMapping(value = "/operator/edit/service_centers/{id:\\d+}", method = RequestMethod.GET)
    public String editServiceCenterPage(@PathVariable Long id, ModelMap modelMap) {
        ServiceCenter serviceCenter = serviceCenterService.findById(id);

        if (serviceCenter != null) {
            modelMap.put("service_center", serviceCenter);
            modelMap.addAttribute("service_center_form", new AddServiceCenterForm());
        } else {
            modelMap.put("not_found", true);
        }

        return "edit_service_center";
    }

    @RequestMapping(value = "/operator/edit/service_centers/{id:\\d+}", method = RequestMethod.POST)
    public String editServiceCenter(@PathVariable Long id, ModelMap modelMap, @ModelAttribute("service_center_form") @Valid AddServiceCenterForm form, BindingResult result) {
        ServiceCenter serviceCenter = serviceCenterService.findById(id);

        if (result.hasErrors()) {
            modelMap.put("service_center", serviceCenter);

            return "edit_service_center";
        }

        String name = form.getName();
        String address = form.getAddress();
        String phone = form.getPhone();

        serviceCenter.setName(name);
        serviceCenter.setAddress(address);
        serviceCenter.setPhone(phone);

        serviceCenterService.update(serviceCenter);

        return "redirect:/operator/service_centers/" + id;
    }

    @RequestMapping(value = "/operator/service_centers/{id:\\d+}", method = RequestMethod.GET)
    public String serviceCenterPage(@PathVariable Long id, ModelMap modelMap) {
       ServiceCenter serviceCenter = serviceCenterService.findById(id);

        if (serviceCenter != null) {
            modelMap.put("service_center", serviceCenter);
        } else {
            modelMap.put("not_found", true);
        }
        return "service_center";
    }
}
