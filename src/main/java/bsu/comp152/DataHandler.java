package bsu.comp152;

import com.google.gson.Gson;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DataHandler {

    private HttpClient dataGrabber;
    private String webLocation;

    public DataHandler(String webLocation){
        dataGrabber = HttpClient.newHttpClient();
        this.webLocation = webLocation;
    }

    public ArrayList<JokeDataType> getData() {
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
        String Category;
        String Backlist;
        @Override
        public String toString(){
            return Category;

        }
    }
    public ArrayList<responseDataType> getData1(){
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch (IIOException e){
            System.out.println("Error connecting to network or site");
        }
        catch (InterruptedException e){
            System.out.println("Connection to site broken");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response == null ){
            System.out.println("Something went terribly wrong, ending program");
            System.exit(-1);
        }
        var usefulData = response.body();
        var jsonInterpreter = new Gson();
        var weather = jsonInterpreter.fromJson(usefulData, responseDataType1.class);
        return weather.results;
    }

    class responseDataType1{
        String currentDay;
        String threeDay;
        String fiveDay;
        String tenDay;
        ArrayList<responseDataType>results;


        class WeatherType {
            String currentDay;
            String threeDay;
            String fiveDay;
            String tenDay;

            @Override
            public String toString() {
                return "Weather: " + currentDay;

            }

        }
    }

    // Code for currency window
    public Array<currencyDataType> currencyGetData(){
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch(IOException e){
            System.out.println("Error connecting to network or site");
        }
        catch (InterruptedException e){
            System.out.println("Connection to site broken");
        }
        if (response == null ){
            System.out.println("Something went wrong, ending program");
            System.exit(-1);
        }
        var usefulData = response.body();
        var jsonInterpreter = new Gson();
        var currencyData = jsonInterpreter.fromJson(usefulData, responseDataType.class);
        return currencyData.results;

    }

    class currencyResponseDataType{
        String rates;
        float version;
        ArrayList<currencyDataType> results;
    }

    class currencyDataType {
        String rates;


        @Override
        public String toString() {
            return rates;
        }

    }
}
