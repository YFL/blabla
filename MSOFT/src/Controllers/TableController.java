package Controllers;

import Model.Nehnutelnost;

import java.io.IOException;
import java.lang.reflect.Array;
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
    private ArrayList<Nehnutelnost> f = new ArrayList<>();
    private final int NEHNUTELNOSTI_PER_STRANA;
    private int firstIndex;
    private int lastIndex;
    @FXML private TableView<Nehnutelnost> table_f;
    @FXML private TableColumn<Nehnutelnost, String> col_name = new TableColumn<>();
    @FXML private TableColumn<Nehnutelnost, Integer> col_id = new TableColumn<>();
    @FXML private TableColumn<Nehnutelnost, String> col_type = new TableColumn<>();
    @FXML private Button Up;
    @FXML private Button Down;
    @FXML private Button Add;
    @FXML private TextField screen;
    @FXML private Tab databazanehnutelnosti;

    public TableController()
    {
        NEHNUTELNOSTI_PER_STRANA = 25;
        firstIndex = 0;
        lastIndex = 24;
    }

    @FXML private void zobrazdatabazu() {
        ArrayList<Nehnutelnost> subArray = new ArrayList<>();
        for(int i = firstIndex; i <= lastIndex && i < f.size(); i++)
        {
            subArray.add(f.get(i));
        }
        table_f.getItems().clear();
        table_f.getItems().addAll(subArray);
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        setCellTable1();
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
    private void up() {
        indiciesUp();
        table_f.getItems().clear();
        zobrazdatabazu();
    }

    @FXML
    private void down() {
        indiciesDown();
        table_f.getItems().clear();
        zobrazdatabazu();
    }


    private void setCellTable1(){
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    private void indiciesUp()
    {
        if(firstIndex - NEHNUTELNOSTI_PER_STRANA >= 0)
        {
            firstIndex -= NEHNUTELNOSTI_PER_STRANA;
            lastIndex -= NEHNUTELNOSTI_PER_STRANA;
        }
    }

    private void indiciesDown()
    {
        if(firstIndex + NEHNUTELNOSTI_PER_STRANA < f.size())
        {
            firstIndex += NEHNUTELNOSTI_PER_STRANA;
            lastIndex += NEHNUTELNOSTI_PER_STRANA;
        }
    }
}