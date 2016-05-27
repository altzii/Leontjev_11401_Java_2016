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
import ru.kpfu.itis.leontjev.desktop_fx.controller.AddClientController;
import ru.kpfu.itis.leontjev.desktop_fx.controller.ClientsController;
import ru.kpfu.itis.leontjev.desktop_fx.controller.MenuController;
import ru.kpfu.itis.leontjev.desktop_fx.controller.SigninController;
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

    @Qualifier("menuLoader")
    @Autowired
    private FXMLLoader menuLoader;

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

    public void showAddClient() {
        if (user != null) {
            currentPage = Page.ADD_CLIENT;
            AnchorPane testPage = addClientLoader.getRoot();
            rootLayout.setCenter(testPage);
            AddClientController controller = addClientLoader.getController();
            controller.setMainApp(this);

        } else showLogin();
    }
}
