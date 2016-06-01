package ru.kpfu.itis.leontjev.desktop_fx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.leontjev.desktop_fx.MainApplication;
import ru.kpfu.itis.leontjev.desktop_fx.entity.DeviceType;

import java.io.IOException;
import java.util.List;

/**
 * Created by alt on 27/05/2016.
 */

public class DeviceTypesController {
    @FXML
    private TableView<DeviceType> deviceTypesTable;
    private ObservableList<DeviceType> deviceTypes = FXCollections.observableArrayList();

    @FXML
    private TableColumn<DeviceType, String> name;

    private MainApplication mainApp;

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        initDeviceTypes();
        deviceTypesTable.setItems(deviceTypes);
    }

    private void initDeviceTypes() {
        try {
            deviceTypes = FXCollections.observableArrayList();
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/rest/api/device_types";
            ObjectMapper objectMapper = new ObjectMapper();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", mainApp.getUser().getHeader());
            HttpEntity<String> request = new HttpEntity<String>(headers);
            String json = restTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody();
            List<DeviceType> deviceTypesList = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, DeviceType.class));
            deviceTypes.addAll(deviceTypesList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ResourceAccessException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Нет соединения с сервером");
            alert.setContentText("Внимание! Ошибка соединения с сервером!");
            alert.showAndWait();
            mainApp.showLogin();
        }

    }

    @FXML
    public void initialize() {
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
    }
}