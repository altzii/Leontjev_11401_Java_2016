package ru.kpfu.itis.leontjev.warranty_department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.leontjev.warranty_department.entity.*;
import ru.kpfu.itis.leontjev.warranty_department.service.*;

import java.util.List;

/**
 * Created by alt on 27/06/2016.
 */
@Controller
@RequestMapping(value = "rest/api")
public class RestController {
    @Autowired
    UserService userService;

    @Autowired
    ClientService clientService;

    @Autowired
    ServiceCenterService serviceCenterService;

    @Autowired
    BrandService brandService;

    @Autowired
    DeviceTypeService deviceTypeService;


    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public
    @ResponseBody
    User signin(@RequestParam(value = "login") String username, @RequestParam(value = "password") String password) {

        User user = userService.findByLogin(username);

        if (user != null) {
            BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(12);
            bcryptEncoder.encode(password);

            if (bcryptEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Client> getClients() {
        return clientService.findAll();
    }

    @RequestMapping(value = "/clients/add", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean addClient(@RequestParam(value = "name", required = true) String name,
                      @RequestParam(value = "phone", required = true) String phone,
                      @RequestParam(value = "address", required = true) String address) {
        Client client = new Client();
        client.setName(name);
        client.setPhone(phone);
        client.setAddress(address);

        clientService.create(client);

        return true;
    }

    @RequestMapping(value = "/service_centers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ServiceCenter> getServiceCenters() {
        return serviceCenterService.findAll();
    }

    @RequestMapping(value = "/service_centers/add", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean addServiceCenter(@RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "phone", required = true) String phone,
                             @RequestParam(value = "address", required = true) String address) {
        ServiceCenter serviceCenter = new ServiceCenter();
        serviceCenter.setName(name);
        serviceCenter.setPhone(phone);
        serviceCenter.setAddress(address);

        serviceCenterService.create(serviceCenter);

        return true;
    }

    @RequestMapping(value = "/device_types", method = RequestMethod.GET)
    public
    @ResponseBody
    List<DeviceType> getDeviceTypes() {
        return deviceTypeService.findAll();
    }

    @RequestMapping(value = "/device_types/add", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean addDeviceType(@RequestParam(value = "name", required = true) String name) {
        DeviceType deviceType = new DeviceType();
        deviceType.setName(name);


        deviceTypeService.create(deviceType);

        return true;
    }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Brand> getBrands() {
        return brandService.findAll();
    }

    @RequestMapping(value = "/brands/add", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean addBrand(@RequestParam(value = "name", required = true) String name) {
        Brand brand = new Brand();
        brand.setName(name);

        brandService.create(brand);

        return true;
    }
}
