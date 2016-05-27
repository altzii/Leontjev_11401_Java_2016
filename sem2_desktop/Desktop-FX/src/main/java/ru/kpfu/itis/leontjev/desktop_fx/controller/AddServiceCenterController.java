package ru.kpfu.itis.leontjev.desktop_fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.leontjev.desktop_fx.MainApplication;

/**
 * Created by alt on 27/05/2016.
 */

public class AddServiceCenterController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField addressField;

    private MainApplication mainApp;
    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
    }

    private void showOk() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(mainApp.getPrimaryStage());
        alert.setTitle("Сервисный центр успешно добавлен");
        alert.setContentText("Сервисный центр успешно добавлен");
        alert.showAndWait();
    }

    @FXML
    private void handleAddServiceCenter() {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/rest/api/service_centers/add";

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", mainApp.getUser().getHeader());

            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            params.add("name", nameField.getText());
            params.add("phone", phoneField.getText());
            params.add("address", addressField.getText());

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

            Boolean added = restTemplate.postForEntity(url, request, Boolean.class).getBody();

            if (added) {
                mainApp.showAddServiceCenter();
                showOk();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Ошибка сервера");
                alert.setContentText("Ошибка сервера");
                alert.showAndWait();
            }

        } catch (ResourceAccessException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Нет соединения с сервером");
            alert.setContentText("Нет соединения с сервером");
            alert.showAndWait();
            mainApp.showLogin();
        }
    }
}
