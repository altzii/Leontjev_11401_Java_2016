package ru.kpfu.itis.leontjev.warranty_department.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alexander on 02/05/2016.
 */
@ControllerAdvice
public class GlobalController {
    @ModelAttribute()
    public void addUserAttributes(ModelMap model, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            model.put("username",  authentication.getName());
        }
    }
}
