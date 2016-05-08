package ru.kpfu.itis.leontjev.warranty_department.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Alexander on 04/05/2016.
 */
public class AddServiceCenterForm {
    @NotEmpty(message = "Введите название сервисного центра")
    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String phone;

    @Size(max = 100)
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
