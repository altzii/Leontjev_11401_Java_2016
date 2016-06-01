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
import ru.kpfu.itis.leontjev.desktop_fx.entity.ServiceCenter;

import java.io.IOException;
import java.util.List;

/**
 * Created by alt on 27/05/2016.
 */
public class ServiceCentersController {
    @FXML
    private TableView<ServiceCenter> serviceCentersTable;
    private ObservableList<ServiceCenter> serviceCenters = FXCollections.observableArrayList();

    @FXML
    private TableColumn<ServiceCenter, String> name;
    @FXML
    private TableColumn<ServiceCenter, String> phone;
    @FXML
    private TableColumn<ServiceCenter, String> address;


    private MainApplication mainApp;

    public void setMainApp(MainApplication mainApp) {
        this.mainApp = mainApp;
        initServiceCenters();
        serviceCentersTable.setItems(serviceCenters);
    }

    private void initServiceCenters() {
        try {
            serviceCenters = FXCollections.observableArrayList();
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/rest/api/service_centers";
            ObjectMapper objectMapper = new ObjectMapper();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", mainApp.getUser().getHeader());
            HttpEntity<String> request = new HttpEntity<String>(headers);
            String json = restTemplate.exchange(url, HttpMethod.GET, request, String.class).getBody();
            List<ServiceCenter> serviceCentersList = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, ServiceCenter.class));
            serviceCenters.addAll(serviceCentersList);
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
        phone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhone()));
        address.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));
    }
}
