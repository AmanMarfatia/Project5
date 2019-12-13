package bsu.comp152;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;

public class CurrencyController implements Initializable {
    @FXML
    private ListView<DataHandler.currencyDataType> ListControl;
    private DataHandler Model;
    private String chosenCurrency;
    private TextField box1;
    private TextField box2;
    private TextField box3;
    private TextField box4;
    private TextField box5;
    private TextField box6;
    private TextField box7;
    private TextField box8;


    public String currencyLoadData() throws IOException {
        var site = "https://api.exchangerate-api.com/v4/latest/" + chosenCurrency;
        var params = getQueryParameters();
        var query = site + params;

        Model = new DataHandler(query);
        var recipeList = Model.getData();
        DataHandler.currencyDataType currencyList;
        ObservableList<DataHandler.currencyDataType> dataToShow = FXCollections.observableArrayList(currencyList);
        ListControl.setItems(dataToShow);

        // Making request
        URL url = new URL(site);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Converting to JSON
        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj - root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("result").getAsString();
        return req_result;
    }

    private String getQueryParameters() {
        var chosenCurrency = getChosenCurrency();
        return chosenCurrency;
    }

    public String getChosenAmount() {
        TextInputDialog answer = new TextInputDialog("1");
        answer.setContentText("Input amount:");
        Optional<String> result = answer.showAndWait();
        if (result.isPresent())
            return result.get();
        else
            return "";

    }

    private String getChosenCurrency(){
        return chosenCurrency;
    }


    public void makeConversion(HashMap req_result){
        HashMap resultRates = req_result;
        var rates = resultRates.get("rates");
        var usdRate = rates.get("USD");
        var audRate = rates.get("AUD");
        var cadRate = rates.get("CAD");
        var chfRate = rates.get("CHF");
        var cnyRate = rates.get("CNY");
        var eurRate = rates.get("EUR");
        var gbpRate = rates.get("GBP");
        var hkdRate = rates.get("HKD");

        box1.setText((result * usdRate)+ "USD");
        box2.setText((result * audRate)+ "AUD");
        box3.setText((result * cadRate)+ "CAD");
        box4.setText((result * chfRate)+ "CHF");
        box5.setText((result * cnyRate)+ "CNY");
        box6.setText((result * eurRate)+ "EUR");
        box7.setText((result * gbpRate)+ "GBP");
        box8.setText((result * hkdRate)+ "HKD");

        }

    }


}
