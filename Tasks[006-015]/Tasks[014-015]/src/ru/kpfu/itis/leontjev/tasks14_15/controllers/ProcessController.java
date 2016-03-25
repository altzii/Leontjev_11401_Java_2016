package ru.kpfu.itis.leontjev.tasks14_15.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexander on 23/03/2016.
 */
@Controller
@RequestMapping("/process")
public class ProcessController {
    @RequestMapping(method = RequestMethod.GET)
    public String processPage() {
        return "process";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String process(ModelMap modelMap, @RequestParam(name = "oper") String oper, @RequestParam(name = "text") String text) {
        int result = 0;

        if (oper.equals("symbols")) {
            result = text.length();
        }
        if (oper.equals("words")) {
            result = (text.split(" ")).length;
        }
        if (oper.equals("paragraphs")) {
            result = (text.split("\\n")).length;
        }
        if (oper.equals("sentences")) {
            Pattern pattern = Pattern.compile("[\\.!?]+");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                result++;
            }
        }

        ]
    }
}
