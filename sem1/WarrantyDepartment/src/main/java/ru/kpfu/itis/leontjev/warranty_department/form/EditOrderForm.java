package ru.kpfu.itis.leontjev.warranty_department.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Alexander on 08/05/2016.
 */
public class EditOrderForm {
    @NotEmpty
    private String clientId;

    @NotEmpty
    private String deviceTypeId;

    @NotEmpty
    private String brandId;

    private String model;

    @NotEmpty(message = "Опишите неисправность")
    private String defect;

    @Size(max = 10)
    private String purchaseDate;

    @Size(max = 10)
    private String sentDate;

    @NotEmpty
    private String statusId;

    private String serviceCenterId;


    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public String getServiceCenterId() {
        return serviceCenterId;
    }

    public void setServiceCenterId(String serviceCenterId) {
        this.serviceCenterId = serviceCenterId;
    }
}
