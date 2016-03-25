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
@RequestMapping("/{address:baidu|bing|yahoo|aol}/search")
public class SearchController {
    @RequestMapping(method = RequestMethod.GET)
    public String searchPage(ModelMap model, @PathVariable String address) {
        String name = "";
        if (address.equals("baidu")) {
            address = "http://www.baidu.com/s?ie=utf-8&wd=";
            name = "wd";
        }
        if (address.equals("bing")) {
            address = "http://www.bing.com/search?q=f";
            name = "q";
        }

        if (address.equals("yahoo")) {
            address = "https://search.yahoo.com/search?p=";
            name = "p";
        }

        if (address.equals("aol")) {
            address = "http://search.aol.com/search?q=";
            name = "q";
        }

        model.put("address", address);
        model.put("name", name);

        return "search";
    }
}
