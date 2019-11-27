package bsu.comp152;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javax.swing.text.html.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JokesController implements Initializable {
    @FXML
    //private ListView<DataHandler.JokeDataType>ListControl;
    private DataHandler Model;

    public void loadData() {
        var site = "https://sv443.net/jokeapi";
        var params = getQueryParameters();
        var query = site + params;

        Model = new DataHandler(query);
        var jokeList = Model.getData();
        ObservableList<DataHandler.JokeDataType> dataToShow = FXCollections.observableArrayList(jokeList);
        ListControl.setItems(dataToShow);
    }

    public String getQueryParameters() {
        //var joke = getJokesType();
        // Get the category of jokes that the user wants (call a method that does this) (category)
        // Get the topics the user doesn't want to joke about (call a method that does this) (back list)
        //
        return "food";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
        ListControl.getSelectionModel().selectedItemProperty

    }
}