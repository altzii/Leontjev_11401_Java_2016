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
import ru.kpfu.itis.leontjev.warranty_department.entity.DeviceType;
import ru.kpfu.itis.leontjev.warranty_department.form.AddDeviceTypeForm;
import ru.kpfu.itis.leontjev.warranty_department.service.DeviceTypeService;

import javax.validation.Valid;

/**
 * Created by Alexander on 03/05/2016.
 */
@Controller
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping(value = "/operator/device_types", method = RequestMethod.GET)
    public String deviceTypes(ModelMap model) {
        model.put("device_types", deviceTypeService.findAll());
        return "/device_types";
    }

    @RequestMapping(value = "/operator/delete/device_types/{id:\\d+}", method = RequestMethod.POST)
    public String deleteStatus(@PathVariable String id) {
        deviceTypeService.delete(Integer.parseInt(id));
        return "redirect:/operator/device_types";
    }


    @RequestMapping(value = "/operator/device_types/add", method = RequestMethod.GET)
    public String addStatusPage(Model model) {
        model.addAttribute("status_form", new AddDeviceTypeForm());
        return "/add_device_type";
    }

    @RequestMapping(value = "operator/device_types/add", method = RequestMethod.POST)
    public String addStatus(@ModelAttribute("device_type_form") @Valid AddDeviceTypeForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/operator/device_types/add";
        }

        String name = form.getName();
        DeviceType deviceType = new DeviceType();
        deviceType.setName(name);

        deviceTypeService.create(deviceType);

        return "redirect:/operator/device_types/";
    }
}
