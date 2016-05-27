package ru.kpfu.itis.leontjev.desktop_fx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import ru.kpfu.itis.leontjev.desktop_fx.controller.*;
import ru.kpfu.itis.leontjev.desktop_fx.entity.User;
import ru.kpfu.itis.leontjev.desktop_fx.enumeration.Page;

/**
 * Created by alt on 27/05/2016.
 */

@Lazy
@SpringBootApplication
public class MainApplication extends AbstractJavaFxApplicationSupport {
    private User user;
    private MenuController menuController;

    Page currentPage = Page.LOGIN;

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Qualifier("loginLoader")
    @Autowired
    private FXMLLoader loginLoader;

    @Qualifier("clientsLoader")
    @Autowired
    private FXMLLoader clientsLoader;

    @Qualifier("addClientLoader")
    @Autowired
    private FXMLLoader addClientLoader;

    @Qualifier("serviceCentersLoader")
    @Autowired
    private FXMLLoader serviceCentersLoader;

    @Qualifier("addServiceCenterLoader")
    @Autowired
    private FXMLLoader addServiceCenterLoader;

    @Qualifier("deviceTypesLoader")
    @Autowired
    private FXMLLoader deviceTypesLoader;

    @Qualifier("addDeviceTypeLoader")
    @Autowired
    private FXMLLoader addDeviceTypeLoader;

    @Qualifier("brandsLoader")
    @Autowired
    private FXMLLoader brandsLoader;

    @Qualifier("addBrandLoader")
    @Autowired
    private FXMLLoader addBrandLoader;

    @Qualifier("menuLoader")
    @Autowired
    private FXMLLoader menuLoader;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public static void main(String[] args) {
        launchApp(MainApplication.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Панель управления");
        initRootLayout();
        showLogin();
    }

    public void initRootLayout() {
        rootLayout = menuLoader.getRoot();
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        menuController = menuLoader.getController();
        menuController.setMainApp(this);
    }

    public void showLogin() {
        user = null;
        currentPage = Page.LOGIN;
        AnchorPane loginPage = (AnchorPane) loginLoader.getRoot();
        rootLayout.setCenter(loginPage);
        SigninController controller = loginLoader.getController();
        controller.setMainApp(this);
    }

    public void showClients() {
        if (user != null) {
            currentPage = Page.CLIENTS;
            AnchorPane testPage = clientsLoader.getRoot();
            rootLayout.setCenter(testPage);
            ClientsController controller = clientsLoader.getController();
            controller.setMainApp(this);
        } else showLogin();
    }

    public void showAddClient() {
        if (user != null) {
            currentPage = Page.ADD_CLIENT;
            AnchorPane testPage = addClientLoader.getRoot();
            rootLayout.setCenter(testPage);
            AddClientController controller = addClientLoader.getController();
            controller.setMainApp(this);

        } else showLogin();
    }

    public void showAddServiceCenter() {
        if (user != null) {
            currentPage = Page.ADD_SERVICE_CENTER;
            AnchorPane testPage = addServiceCenterLoader.getRoot();
            rootLayout.setCenter(testPage);
            AddServiceCenterController controller = addServiceCenterLoader.getController();
            controller.setMainApp(this);

        } else showLogin();
    }

    public void showServiceCenters() {
        if (user != null) {
            currentPage = Page.SERVICE_CENTERS;
            AnchorPane testPage = serviceCentersLoader.getRoot();
            rootLayout.setCenter(testPage);
            ServiceCentersController controller = serviceCentersLoader.getController();
            controller.setMainApp(this);
        } else showLogin();
    }

    public void showAddDeviceType() {
        if (user != null) {
            currentPage = Page.ADD_DEVICE_TYPE;
            AnchorPane testPage = addDeviceTypeLoader.getRoot();
            rootLayout.setCenter(testPage);
            AddDeviceTypeController controller = addDeviceTypeLoader.getController();
            controller.setMainApp(this);

        } else showLogin();
    }

    public void showDeviceTypes() {
        if (user != null) {
            currentPage = Page.DEVICE_TYPES;
            AnchorPane testPage = deviceTypesLoader.getRoot();
            rootLayout.setCenter(testPage);
            DeviceTypesController controller = deviceTypesLoader.getController();
            controller.setMainApp(this);
        } else showLogin();
    }

    public void showAddBrand() {
        if (user != null) {
            currentPage = Page.ADD_BRAND;
            AnchorPane testPage = addBrandLoader.getRoot();
            rootLayout.setCenter(testPage);
            AddBrandController controller = addBrandLoader.getController();
            controller.setMainApp(this);

        } else showLogin();
    }

    public void showBrands() {
        if (user != null) {
            currentPage = Page.BRANDS;
            AnchorPane testPage = brandsLoader.getRoot();
            rootLayout.setCenter(testPage);
            BrandsController controller = brandsLoader.getController();
            controller.setMainApp(this);
        } else showLogin();
    }
}
