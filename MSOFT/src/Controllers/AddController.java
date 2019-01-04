package Controllers;

import Model.Nehnutelnost;
import com.sun.istack.internal.NotNull;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField type;
    @FXML
    private Button Add;

    private ArrayList<Nehnutelnost> nehnutelnosti;

    public AddController(@NotNull ArrayList<Nehnutelnost> nehnutelnosti)
    {
        this.nehnutelnosti = nehnutelnosti;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    @FXML
    public void add(ActionEvent event) {
        nehnutelnosti.add(new Nehnutelnost(name.getText(), type.getText()));
    }
}