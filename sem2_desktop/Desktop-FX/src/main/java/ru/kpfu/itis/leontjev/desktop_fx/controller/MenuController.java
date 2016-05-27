package ru.kpfu.itis.leontjev.desktop_fx.controller;

import javafx.fxml.FXML;
import ru.kpfu.itis.leontjev.desktop_fx.MainApplication;
import ru.kpfu.itis.leontjev.desktop_fx.enumeration.Page;

/**
 * Created by alt on 27/05/2016.
 */

public class MenuController {
    private MainApplication mainApp;

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLogin() {
        if (mainApp.getCurrentPage() != Page.LOGIN) {
            mainApp.showLogin();
        }
    }

    @FXML
    private void handleClients() {
        if (mainApp.getCurrentPage() != Page.CLIENTS) {
            mainApp.showClients();
        }
    }

    @FXML
    private void handleAddClient() {
        if (mainApp.getCurrentPage() != Page.ADD_CLIENT) {
            mainApp.showAddClient();
        }
    }

    @FXML
    private void handleServiceCenters() {
        if (mainApp.getCurrentPage() != Page.SERVICE_CENTERS) {
            mainApp.showServiceCenters();
        }
    }

    @FXML
    private void handleAddServiceCenter() {
        if (mainApp.getCurrentPage() != Page.ADD_SERVICE_CENTER) {
            mainApp.showAddServiceCenter();
        }
    }

    @FXML
    private void handleDeviceTypes() {
        if (mainApp.getCurrentPage() != Page.DEVICE_TYPES) {
            mainApp.showDeviceTypes();
        }
    }

    @FXML
    private void handleAddDeviceType() {
        if (mainApp.getCurrentPage() != Page.ADD_DEVICE_TYPE) {
            mainApp.showAddDeviceType();
        }
    }

    @FXML
    private void handleBrands() {
        if (mainApp.getCurrentPage() != Page.BRANDS) {
            mainApp.showBrands();
        }
    }

    @FXML
    private void handleAddBrand() {
        if (mainApp.getCurrentPage() != Page.ADD_BRAND) {
            mainApp.showAddBrand();
        }
    }


}
