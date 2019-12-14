package bsu.comp152;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javax.swing.event.ChangeListener;
import javax.swing.text.html.ListView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JokesController implements Initializable {
    //public CheckBox miscellaneous;
    //public CheckBox programming;
    //public CheckBox any;
    public CheckBox religious;
    public CheckBox political;
   //private String JokeType;
    private String blacklistFlag;
    @FXML
    private ListView<DataHandler.JokeDataType>ListControl;
    private ArrayList<CheckBox> allCheckBoxes;
    private DataHandler Model;
    private String JokeType;

    public void loadData(ActionEvent event) {
        var site = "https://sv443.net/jokeapi";
        var params = getQueryParameters();
        var query = site + params;
        Model = new DataHandler(query);
        var jokeList = Model.getData();
        ObservableList<DataHandler.JokeDataType> dataToShow = FXCollections.observableArrayList(jokeList);
        ListControl.setItems(dataToShow);
    }

    public String getQueryParameters() {
        var jokeCategory = getJokesType();
        var blacklistFlags = getBad();
        return "i="+jokeCategory+"&q"+blacklistFlags;
    }
    private String getBad() {
        var bad = "";
        for (var box : allCheckBoxes) {
            if (box isSelected()){
                var text = box.getText();
                if (bad.length() > 0) {
                    bad = bad + "," text;
                } else
                    bad = text;
            }
        }

        private String getJokesType () {
            return JokeType;
        }
        @Override
        public void initialize (URL location, ResourceBundle resources){
            JokeType = "";
            allCheckBoxes = new ArrayList<CheckBox>();
            allCheckBoxes.add(political);
            allCheckBoxes.add(religious);
            ListControl.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<DataHandler.JokeDataType> {
                @Override
                public void changed (ObservableValue < ? extends
                DataHandler.JokeDataType > Observable, DataHandler.JokeDataType oldValue, DataHandler.JokeDataType
                NewValie ){
                    var food = ListControl.getSelectionModel().getSelectedItem();
                    Alert info = new Alert(Alert.AlertType.INFORMATION);
                    info.setHeaderText(("Category: " + jokeCategory));

                }
            }
            );
        }
    }

    @FXML
    public void selectMenuItem(javafx.event.ActionEvent actionEvent){
        var item = (MenuItem)actionEvent.getSource();
        JokeType = item.getText();
    }
}