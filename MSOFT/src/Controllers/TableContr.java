package Controllers;

import Model.Nehnutelnost;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
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

    private Connection CONN = null;
    private ObservableList<Nehnutelnost> data;
    private PreparedStatement pSt=null;
    private ResultSet rS=null;
    private Nehnutelnost f;
    private LinkedList lastshown=new LinkedList();
    @FXML private TableView<Nehnutelnost> table_f;
    @FXML private TableColumn<?,?> col_name;
    @FXML private TableColumn<?,?> col_id;
    @FXML private TableColumn<?,?> col_typ;
    @FXML private Button Up;
    @FXML private Button Down;
    @FXML private Button Add;
    @FXML private TextField screen;
    @FXML private Tab databazanehnutelnosti;

    @FXML void watch() throws SQLException {
    }

    @FXML void zobrazdatabazu(){
        setCellTable1();
        lastshown.clear();
        data= FXCollections.observableArrayList();
        data.removeAll();
        table_f.getItems().clear();
        lastshown.add(0);
        try {
            if(CONN==null) CONN= DBconnector.getconnection();
            showData1();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void add() throws IOException {
        Stage stage=new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource("/gui/add.fxml"));
        stage.setTitle("Pridaj nehnutelnost");
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();

    }

    @FXML
    void up() throws SQLException {
        data.removeAll();
        table_f.getItems().clear();
        lastshown.removeLast();
        lastshown.removeLast();
        showData1();
    }

    @FXML
    void down() throws SQLException {
        data.removeAll();
        table_f.getItems().clear();
        showData1();
    }


    private void setCellTable1(){
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_typ.setCellValueFactory(new PropertyValueFactory<>("typ");
    }


}