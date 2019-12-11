package bsu.comp152;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController implements Initializable {
    @FXML
    public TextField NameField;
    public TextField CultureField;
    public TextField BornField;
    public TextField TitleField;
    public TextField inputName;
    private Model dataModel;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        dataModel = new Model();
    }

    public void loadData(ActionEvent event){
        var site = "https://www.metaweather.com/api/";
        var input = inputName.getText();
        if (input.length() <1){
            Alert box = new Alert(Alert.AlertType.INFORMATION);
            box.setContentText("Enter a city");
            box.showAndWait();
            return;
        }
        site = site+ "city/"+input;
        weatherData data = dataModel.GetData(site);
        displayData(data);
    }

    public void displayData(weatherData data){
        NameField.setText(data.name);
        CultureField.setText(data.culture);
        BornField.setText(data.born);
        if(data.titles.size() >=1)
            TitleField.setText(data.titles.get(0));
    }

}
