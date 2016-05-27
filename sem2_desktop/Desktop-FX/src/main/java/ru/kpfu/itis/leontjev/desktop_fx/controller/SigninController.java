package ru.kpfu.itis.leontjev.desktop_fx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.leontjev.desktop_fx.MainApplication;
import ru.kpfu.itis.leontjev.desktop_fx.entity.User;

import java.io.IOException;

/**
 * Created by alt on 27/05/2016.
 */

public class SigninController {
    private MainApplication mainApp;

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleSignin() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/api/signin";
        HttpHeaders headers = new HttpHeaders();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

            params.add("login", loginField.getText());
            params.add("password", passwordField.getText());

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);

            String json = restTemplate.postForEntity(url, request, String.class, params).getBody();
            User user;

            if (json != null) {
                user = objectMapper.readValue(json, User.class);
                mainApp.setUser(user);
                mainApp.getUser().setPassword(passwordField.getText());
                System.out.println("Signed in successfully!");
                mainApp.showClients();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainApp.getPrimaryStage());
                alert.setTitle("Неправильный логин или пароль");
                alert.setContentText("Неправильный логин или пароль");
                alert.showAndWait();
            }
        } catch (HttpClientErrorException | IOException e) {
            e.printStackTrace();
        }
    }


}

