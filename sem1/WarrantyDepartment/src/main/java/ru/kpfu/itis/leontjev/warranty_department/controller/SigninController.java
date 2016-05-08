package ru.kpfu.itis.leontjev.warranty_department.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Alexander on 22/04/2016.
 */

@Controller
public class SigninController {
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(@RequestParam(value = "from_signup", required = false) boolean status, @RequestParam(value = "error", required = false) boolean error, ModelMap model) {
        if (status) {
            model.put("from_signup", true);
        }
        if (error) {
            model.addAttribute("error", true);
        }
        return "/signin";
    }
}