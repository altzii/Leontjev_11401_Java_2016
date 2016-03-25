package ru.kpfu.itis.leontjev.tasks14_15.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Alexander on 23/03/2016.
 */
@Controller
@RequestMapping(value = "/result")
public class ResultController {
    @RequestMapping(method = RequestMethod.GET)
    public String resultPage(ModelMap modelMap, @RequestParam("result") int result) {
        modelMap.put("result", result);
        return "result";
    }
}
