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
import ru.kpfu.itis.leontjev.warranty_department.entity.Brand;
import ru.kpfu.itis.leontjev.warranty_department.form.AddBrandForm;
import ru.kpfu.itis.leontjev.warranty_department.service.BrandService;

import javax.validation.Valid;

/**
 * Created by Alexander on 03/05/2016.
 */
@Controller
public class BrandController {
    @Autowired
    BrandService brandService;

    @RequestMapping(value = "/operator/brands", method = RequestMethod.GET)
    public String statuses(ModelMap model) {
        model.put("brands", brandService.findAll());
        return "/brands";
    }

    @RequestMapping(value = "/operator/delete/brands/{id:\\d+}", method = RequestMethod.POST)
    public String deleteBrand(@PathVariable String id) {
        brandService.delete(Integer.parseInt(id));
        return "redirect:/operator/brands";
    }

    @RequestMapping(value = "/operator/brands/add", method = RequestMethod.GET)
    public String addBrandPage(Model model) {
        model.addAttribute("brand_form", new AddBrandForm());
        return "/add_brand";
    }

    @RequestMapping(value = "operator/brands/add", method = RequestMethod.POST)
    public String addBrand(@ModelAttribute("brand_form") @Valid AddBrandForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "/add_brand";
        }

        String name = form.getName();
        Brand brand = new Brand();
        brand.setName(name);

        brandService.create(brand);

        return "redirect:/operator/brands/";
    }

    @RequestMapping(value = "/operator/edit/brands/{id:\\d+}", method = RequestMethod.GET)
    public String editBrandPage(@PathVariable Long id, ModelMap modelMap) {
        Brand brand = brandService.findById(id);

        if (brand != null) {
            modelMap.put("brand", brand);
            modelMap.addAttribute("brand_form", new AddBrandForm());
        } else {
            modelMap.put("not_found", true);
        }

        return "edit_brand";
    }


    @RequestMapping(value = "/operator/edit/brands/{id:\\d+}", method = RequestMethod.POST)
    public String editDeviceType(@PathVariable Long id, ModelMap modelMap, @ModelAttribute("brand_form") @Valid AddBrandForm form, BindingResult result) {
        Brand brand = brandService.findById(id);

        if (result.hasErrors()) {
            modelMap.put("brand", brand);

            return "edit_brand";
        }

        String name = form.getName();

        brand.setName(name);

        brandService.update(brand);

        return "redirect:/operator/brands/";
    }


}
