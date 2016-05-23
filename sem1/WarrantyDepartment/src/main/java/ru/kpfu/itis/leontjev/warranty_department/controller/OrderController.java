package ru.kpfu.itis.leontjev.warranty_department.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.leontjev.warranty_department.entity.*;
import ru.kpfu.itis.leontjev.warranty_department.form.AddOrderFromOperator;
import ru.kpfu.itis.leontjev.warranty_department.form.AddOrderFromUser;
import ru.kpfu.itis.leontjev.warranty_department.form.EditOrderForm;
import ru.kpfu.itis.leontjev.warranty_department.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Alexander on 08/05/2016.
 */
@Controller
public class OrderController {


    @Autowired
    DeviceTypeService deviceTypeService;

    @Autowired
    StatusService statusService;

    @Autowired
    ClientService clientService;

    @Autowired
    BrandService brandService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    ServiceCenterService serviceCenterService;

    User user;

    @RequestMapping(value = "/operator/orders/add", method = RequestMethod.GET)
    public String addOrderFromOperatorPage(ModelMap model) {
        model.addAttribute("order_form", new AddOrderFromOperator());
        model.put("device_types", deviceTypeService.findAllByOrderByNameAsc());
        model.put("statuses", statusService.findAll());
        model.put("clients", clientService.findAllByOrderByNameAsc());
        model.put("brands", brandService.findAll());

        return "/add_order_from_operator";
    }

    @RequestMapping(value = "/operator/orders/add", method = RequestMethod.POST)
    public String addOrderFromOperator(ModelMap modelMap, @ModelAttribute("order_form") @Valid AddOrderFromOperator form, BindingResult result) {
        if (result.hasErrors()) {
            modelMap.put("device_types", deviceTypeService.findAllByOrderByNameAsc());
            modelMap.put("statuses", statusService.findAll());
            modelMap.put("clients", clientService.findAllByOrderByNameAsc());
            modelMap.put("brands", brandService.findAll());

            return "/add_order_from_operator";
        }

        Client client = clientService.findById(Long.parseLong(form.getClientId()));
        DeviceType deviceType = deviceTypeService.findById(Long.parseLong(form.getDeviceTypeId()));
        Brand brand = brandService.findById(Long.parseLong(form.getBrandId()));
        String model = form.getModel();
        String defect = form.getDefect();
        String purchaseDate = form.getPurchaseDate();
        Status status = statusService.findById(Long.parseLong(form.getStatusId()));

        Order order = new Order();

        order.setClient(client);
        order.setDeviceType(deviceType);
        order.setBrand(brand);
        order.setModel(model);
        order.setDefect(defect);
        order.setPurchaseDate(purchaseDate);
        order.setStatus(status);
        order.setOrderDate(new java.sql.Date(System.currentTimeMillis()));

        orderService.create(order);

        return "redirect:/operator/orders/";
    }

    @RequestMapping(value = "/user/orders/add", method = RequestMethod.GET)
    public String addOrderFromUserPage(ModelMap model) {
        model.addAttribute("order_form", new AddOrderFromUser());
        model.put("device_types", deviceTypeService.findAllByOrderByNameAsc());
        model.put("brands", brandService.findAll());

        return "/add_order_from_user";
    }

    @RequestMapping(value = "/user/orders/add", method = RequestMethod.POST)
    public String addOrderFromUser(ModelMap modelMap, @ModelAttribute("order_form") @Valid AddOrderFromUser form, BindingResult result, HttpServletRequest httpServletRequest) {
        user = userService.findByLogin(httpServletRequest.getUserPrincipal().getName());

        if (result.hasErrors()) {
            modelMap.put("device_types", deviceTypeService.findAllByOrderByNameAsc());
            modelMap.put("brands", brandService.findAllByOrderByNameAsc());
            return "/add_order_from_user";
        }

        DeviceType deviceType = deviceTypeService.findById(Long.parseLong(form.getDeviceTypeId()));
        Brand brand = brandService.findById(Long.parseLong(form.getBrandId()));
        String model = form.getModel();
        String defect = form.getDefect();
        String purchaseDate = form.getPurchaseDate();
        Status status = statusService.findByName("В обработке");
        Client client = user.getClient();

        Order order = new Order();

        order.setDeviceType(deviceType);
        order.setBrand(brand);
        order.setModel(model);
        order.setDefect(defect);
        order.setPurchaseDate(purchaseDate);
        order.setStatus(status);
        order.setClient(client);
        order.setOrderDate(new java.sql.Date(System.currentTimeMillis()));

        orderService.create(order);

        return "redirect:/user/orders/";
    }


    @RequestMapping(value = "/user/orders", method = RequestMethod.GET)
    public String ordersFromUserPage(ModelMap modelMap, HttpServletRequest httpServletRequest) {
        user = userService.findByLogin(httpServletRequest.getUserPrincipal().getName());

        modelMap.put("orders", user.getClient().getOrders());

        return "orders_from_user";
    }

    @RequestMapping(value = "/operator/orders", method = RequestMethod.GET)
    public String ordersFromOperatorPage(ModelMap modelMap, @RequestParam(value = "status", required = false) String status) {
        if (status != null && status.equals("new")) {
            modelMap.put("orders", orderService.findAllByStatus(statusService.findByName("В обработке")));
        } else {
            modelMap.put("orders", orderService.findAll());
        }
        return "orders_from_operator";
    }

    @RequestMapping(value = "/admin/delete/orders/{id:\\d+}", method = RequestMethod.POST)
    public String deleteOrder(@PathVariable String id) {
        orderService.delete(Integer.parseInt(id));
        return "redirect:/operator/orders";
    }

    @RequestMapping(value = "/operator/orders/{id:\\d+}", method = RequestMethod.GET)
    public String orderFromOperatorPage(@PathVariable String id, ModelMap modelMap) {
        modelMap.put("order", orderService.findById(Long.parseLong(id)));

        return "order_from_operator";
    }

    @RequestMapping(value = "/operator/edit/orders/{id:\\d+}", method = RequestMethod.GET)
    public String editOrderPage(@PathVariable String id, ModelMap modelMap) {
        modelMap.put("clients", clientService.findAllByOrderByNameAsc());
        modelMap.put("order", orderService.findById(Long.parseLong(id)));
        modelMap.put("device_types", deviceTypeService.findAllByOrderByNameAsc());
        modelMap.put("brands", brandService.findAllByOrderByNameAsc());
        modelMap.put("service_centers", serviceCenterService.findAll());
        modelMap.put("statuses", statusService.findAll());

        modelMap.addAttribute("order_form", new EditOrderForm());

        return "edit_order";
    }

    @RequestMapping(value = "/operator/edit/orders/{id:\\d+}", method = RequestMethod.POST)
    public String editOrder(@PathVariable Long id, ModelMap modelMap, @ModelAttribute("order_form") @Valid EditOrderForm form, BindingResult result) {
        if (result.hasErrors()) {
            modelMap.put("clients", clientService.findAllByOrderByNameAsc());
            modelMap.put("order", orderService.findById(id));
            modelMap.put("device_types", deviceTypeService.findAllByOrderByNameAsc());
            modelMap.put("brands", brandService.findAllByOrderByNameAsc());
            modelMap.put("service_centers", serviceCenterService.findAll());
            modelMap.put("statuses", statusService.findAll());

            return "edit_order";
        }

        Order order = orderService.findById(id);

        Client client = clientService.findById(Long.parseLong(form.getClientId()));
        DeviceType deviceType = deviceTypeService.findById(Long.parseLong(form.getDeviceTypeId()));
        Brand brand = brandService.findById(Long.parseLong(form.getBrandId()));
        String model = form.getModel();
        String purchaseDate = form.getPurchaseDate();
        String sentDate = form.getSentDate();
        String defect = form.getDefect();
        ServiceCenter serviceCenter = serviceCenterService.findById(Long.parseLong(form.getServiceCenterId()));
        Status status = statusService.findById(Long.parseLong(form.getStatusId()));

        order.setClient(client);
        order.setDeviceType(deviceType);
        order.setBrand(brand);
        order.setModel(model);
        order.setPurchaseDate(purchaseDate);
        order.setSentDate(sentDate);
        order.setDefect(defect);
        order.setServiceCenter(serviceCenter);
        order.setStatus(status);

        orderService.update(order);

        return "redirect:/operator/orders";
    }

    @ResponseBody
    @RequestMapping(value = "/operator/pdf/orders/{id:\\d+}", method = RequestMethod.GET, produces = "application/pdf")
    public FileSystemResource downloadPdf(@PathVariable Long id, HttpSession session) throws FileNotFoundException, DocumentException {
        String fontPath = session.getServletContext().getRealPath("/resources/font/");
        Font font = FontFactory.getFont(fontPath + "OpenSans-Regular.ttf", "Cp1251", BaseFont.EMBEDDED);
        font.setSize(12);

        Order order = orderService.findById(id);

        String filename = "order" + id + ".pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        document.add(new Paragraph("Заказ №" + id, font));

        if (order != null) {
            PdfPTable t2 = new PdfPTable(2);
            t2.setSpacingBefore(25);
            t2.setSpacingAfter(25);

            PdfPCell c11 = new PdfPCell(new Phrase("Дата заявки", font));
            t2.addCell(c11);
            PdfPCell c21 = new PdfPCell(new Phrase(order.getOrderDate().toString(), font));
            t2.addCell(c21);

            PdfPCell c12 = new PdfPCell(new Phrase("Клиент", font));
            t2.addCell(c12);
            PdfPCell c22 = new PdfPCell(new Phrase(order.getClient().getName(), font));
            t2.addCell(c22);

            PdfPCell c13 = new PdfPCell(new Phrase("Адрес клиента", font));
            t2.addCell(c13);
            PdfPCell c23 = new PdfPCell(new Phrase(order.getClient().getAddress(), font));
            t2.addCell(c23);

            PdfPCell c14 = new PdfPCell(new Phrase("Телефон клиента", font));
            t2.addCell(c14);
            PdfPCell c24 = new PdfPCell(new Phrase(order.getClient().getPhone(), font));
            t2.addCell(c24);

            PdfPCell c15 = new PdfPCell(new Phrase("Дата покупки клиентом", font));
            t2.addCell(c15);
            PdfPCell c25 = new PdfPCell(new Phrase(order.getPurchaseDate(), font));
            t2.addCell(c25);

            PdfPCell c16 = new PdfPCell(new Phrase("Тип устройства", font));
            t2.addCell(c16);
            PdfPCell c26 = new PdfPCell(new Phrase(order.getDeviceType().getName(), font));
            t2.addCell(c26);

            PdfPCell c17 = new PdfPCell(new Phrase("Производитель", font));
            t2.addCell(c17);
            PdfPCell c27 = new PdfPCell(new Phrase(order.getBrand().getName(), font));
            t2.addCell(c27);

            PdfPCell c18 = new PdfPCell(new Phrase("Модель", font));
            t2.addCell(c18);
            PdfPCell c28 = new PdfPCell(new Phrase(order.getModel(), font));
            t2.addCell(c28);

            PdfPCell c19 = new PdfPCell(new Phrase("Неисправность", font));
            t2.addCell(c19);
            PdfPCell c29 = new PdfPCell(new Phrase(order.getDefect(), font));
            t2.addCell(c29);

            PdfPCell c110 = new PdfPCell(new Phrase("Статус", font));
            t2.addCell(c110);
            PdfPCell c210 = new PdfPCell(new Phrase(order.getStatus().getName(), font));
            t2.addCell(c210);

            document.add(t2);
        }
        document.close();
        return new FileSystemResource(filename);
    }

}
