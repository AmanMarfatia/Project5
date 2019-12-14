package bsu.comp152;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javax.swing.text.html.ListView;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JokesController implements Initializable {
    public CheckBox miscellaneous;
    public CheckBox programming;
    public CheckBox any;
    public CheckBox religious;
    public CheckBox political;
    private String JokeType;
    private String blacklistFlag;

    @Override
public void initialize(URL location, ResourceBundle resources) {
        //loadData();
    }
    @FXML
    //private ListView<DataHandler.JokeDataType>ListControl;
    private DataHandler Model;

    public void loadData(ActionEvent event) {
        var site = "https://sv443.net/jokeapi";
        var params = getQueryParameters();
        var query = site + params;
        Model = new DataHandler(query);
        var jokeList = Model.getData();
        ObservableList<DataHandler.JokeDataType> dataToShow = FXCollections.observableArrayList(jokeList);
        //ListControl.setItems(dataToShow);
    }

    public String getQueryParameters() {
        var jokeCategory = getJokesType();
        var blacklistFlags = getBad();
        return "i="+jokeCategory+"&q"+blacklistFlags;
    }
    private String getBad() {
        return blacklistFlag;
    }

    private String getJokesType(){
        return JokeType;

    }
}