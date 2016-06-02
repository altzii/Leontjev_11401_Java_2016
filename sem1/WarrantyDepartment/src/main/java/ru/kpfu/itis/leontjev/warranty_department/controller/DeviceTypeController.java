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
        model.addAttribute("device_type_form", new AddDeviceTypeForm());
        return "/add_device_type";
    }

    @RequestMapping(value = "operator/device_types/add", method = RequestMethod.POST)
    public String addStatus(@ModelAttribute("device_type_form") @Valid AddDeviceTypeForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/add_device_type";
        }

        String name = form.getName();
        DeviceType deviceType = new DeviceType();
        deviceType.setName(name);

        deviceTypeService.create(deviceType);

        return "redirect:/operator/device_types/";
    }

    @RequestMapping(value = "/operator/edit/device_types/{id:\\d+}", method = RequestMethod.GET)
    public String editDeviceTypePage(@PathVariable Long id, ModelMap modelMap) {
        DeviceType deviceType = deviceTypeService.findById(id);

        if (deviceType != null) {
            modelMap.put("device_type", deviceType);
            modelMap.addAttribute("device_type_form", new AddDeviceTypeForm());
        } else {
            modelMap.put("not_found", true);
        }

        return "edit_device_type";
    }


    @RequestMapping(value = "/operator/edit/device_types/{id:\\d+}", method = RequestMethod.POST)
    public String editDeviceType(@PathVariable Long id, ModelMap modelMap, @ModelAttribute("device_type_form") @Valid AddDeviceTypeForm form, BindingResult result) {
        DeviceType deviceType = deviceTypeService.findById(id);

        if (result.hasErrors()) {
            modelMap.put("device_type", deviceType);

            return "edit_device_type";
        }

        String name = form.getName();

        deviceType.setName(name);

        deviceTypeService.update(deviceType);

        return "redirect:/operator/device_types/";
    }
}
