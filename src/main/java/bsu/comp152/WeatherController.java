package bsu.comp152;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController implements Initializable {
    @FXML
    public TextField CurrentField;
    public TextField ThreeDayField;
    public TextField FiveDayField;
    public TextField TenDayField;
    public TextField inputCity;
    private Model dataModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataModel = new Model();

        public void loadData () {
            var site = "https://www.metaweather.com/api/";
            var input = inputCity.getText();
            if (input.length() < 1) {
                Alert box = new Alert(Alert.AlertType.INFORMATION);
                box.setContentText("Enter a city");
                box.showAndWait();
                return;
            }
            site = site + "city/" + input;
            DataHandler data = dataModel.getData(site);
            displayData(data);
        }

        public void displayData(WeatherType data){
            CurrentField.setText(data.currentDay);  // current day
            ThreeDayField.setText(data.culture); // 3 day
            FiveDayField.setText(data.born); // 5 day
            TenDayField.setText(data.born);

            if (data.titles.size() >= 1)
                TitleField.setText(data.titles.get(0));
        }

    }
}
