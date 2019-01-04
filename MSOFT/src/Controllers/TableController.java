package Controllers;

import Model.Nehnutelnost;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class TableController implements Initializable {
    private ObservableList<Nehnutelnost> data;
    private ArrayList<Nehnutelnost> f = new ArrayList();
    @FXML private TableView<Nehnutelnost> table_f;
    @FXML private TableColumn<Nehnutelnost, String> col_name = new TableColumn<>();
    @FXML private TableColumn<Nehnutelnost, Integer> col_id = new TableColumn<>();
    @FXML private TableColumn<Nehnutelnost, String> col_type = new TableColumn<>();
    @FXML private Button Up;
    @FXML private Button Down;
    @FXML private Button Add;
    @FXML private TextField screen;
    @FXML private Tab databazanehnutelnosti;

    @FXML void watch() {
    }

    @FXML void zobrazdatabazu(){
        data.removeAll();
        data.addAll(f);
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        setCellTable1();
        data = FXCollections.observableArrayList(f);
        table_f.setItems(data);
    }

    @FXML
    public void add() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/add.fxml"));
        AddController ac = new AddController(f);
        loader.setController(ac);
        Parent root = loader.load();
        stage.setTitle("Pridaj nehnutelnost");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.showAndWait();
        zobrazdatabazu();
    }

    @FXML
    void up() {
        data.removeAll();
        table_f.getItems().clear();
    }

    @FXML
    void down() {
        data.removeAll();
        table_f.getItems().clear();
    }


    private void setCellTable1(){
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
    }
}