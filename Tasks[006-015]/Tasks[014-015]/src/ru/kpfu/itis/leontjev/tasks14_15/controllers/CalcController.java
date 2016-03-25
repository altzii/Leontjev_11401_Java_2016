package ru.kpfu.itis.leontjev.tasks14_15.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alexander on 23/03/2016.
 */
@Controller
@RequestMapping("/{oper:add|mult}/{arg1:\\d+}/{arg2:\\d+$}")
public class CalcController {
    @RequestMapping(method = RequestMethod.GET)
    public String searchPage(ModelMap model, @PathVariable String oper, @PathVariable String arg1, @PathVariable String arg2) {
        int res = 0;
        if (oper.equals("add")) {
            res = Integer.parseInt(arg1) + Integer.parseInt(arg2);
        }

        if (oper.equals("mult")) {
            res = Integer.parseInt(arg1) * Integer.parseInt(arg2);
        }
        model.put("res", res);
        return "calc";
    }
}
