package Controllers;

import Model.Nehnutelnost;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AddContr implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField typ;
    @FXML
    private Button Add;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    @FXML
    public void add(ActionEvent event) throws SQLException {
    }
}