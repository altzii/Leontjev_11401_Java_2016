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
    public String signin(@RequestParam(value = "from_signup", required = false) String status, ModelMap model) {
        System.out.println(status);
        if ( status != null && status.equals("1")) {
            model.put("signup_msg", "signup_msg");
        }
        return "/signin";
    }


    @RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
    public String signinFailure() {
        return "/signin_failure";
    }
}