package ru.kpfu.itis.leontjev.tasks14_15.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alexander on 23/03/2016.
 */
@Controller
@RequestMapping("/getdate")
public class GetDateController {
    @RequestMapping(method = RequestMethod.GET)
    public String getDatePage(ModelMap model) {
        model.put("date", new java.util.Date());
        return "getdate";
    }
}
