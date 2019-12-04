package bsu.comp152;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DataHandler {

    @FXML
    private Button Jokes;
    @FXML
    private Button Currency;
    @FXML
    private Button Weather;
    @FXML
    private Button StarWar;

    private HttpClient dataGrabber;
    private String webLocation;

    public DataHandler(String webLocation){
        dataGrabber = HttpClient.newHttpClient();
        this.webLocation = webLocation;
    }
    public ArrayList<JokeDataType>getData() {
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Error connecting to network or site");
        } catch (InterruptedException e) {
            System.out.println("Connection to site broken");
        }
        if (response == null) {
            System.out.println("Something went terribly wrong, ending program");
            System.exit(-1);
        }
        var usefulData = response.body();
        var jsonInterpreter = new Gson();
        var JokeData = jsonInterpreter.fromJson(usefulData, responseDataType.class);
        return JokeData.results;
    }
    class responseDataType{
        String title;
        String type;
        ArrayList<JokeDataType>results;
    }
    class JokeDataType{
        String title;
        String type;
        @Override
        public String toString(){
            return "Jokes: "+ title;
        }
    }
}
