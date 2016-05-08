package ru.kpfu.itis.leontjev.warranty_department.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Alexander on 08/05/2016.
 */
@Entity
@Table(name = "orders", schema = "public", catalog = "warranty_department")
public class Order {
    private Long id;
    private String purchaseDate;
    private Date orderDate;
    private String sentDate;
    private String model;
    private String defect;
    private Client client;
    private Status status;
    private ServiceCenter serviceCenter;
    private Brand brand;
    private DeviceType deviceType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "purchase_date")
    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Basic
    @Column(name = "order_date")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "sent_date")
    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "defect")
    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "service_center_id", referencedColumnName = "id")
    public ServiceCenter getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @ManyToOne
    @JoinColumn(name = "device_type_id", referencedColumnName = "id")
    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order that = (Order) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (sentDate != null ? !sentDate.equals(that.sentDate) : that.sentDate != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (defect != null ? !defect.equals(that.defect) : that.defect != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (sentDate != null ? sentDate.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (defect != null ? defect.hashCode() : 0);
        return result;
    }
}
