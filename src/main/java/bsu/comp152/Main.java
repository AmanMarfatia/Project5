package bsu.comp152;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        var loc = getClass().getResource("Main.fxml");
        try {
            root = FXMLLoader.load(loc);
            //loc.
        } catch (IOException e) {
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 300, 400);
        primaryStage.setScene(windowContents);
        primaryStage.setTitle("Project 5");
        primaryStage.show();
    }

    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);//alls well - bye bye
    }

    @FXML
    public void openJokeWindow(ActionEvent event) {
        Parent root = null;
        var loc = getClass().getResource("JokeWindow.fxml");
        try {
            root = FXMLLoader.load(loc);
        } catch (IOException e) {
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 900, 400);
        Stage jokeWindow = new Stage();
        jokeWindow.setScene(windowContents);
        jokeWindow.setTitle("Joke");
        jokeWindow.show();
    }

    // Currency Window
    @FXML
    public  void openCurrencyWindow(ActionEvent event){
        Parent root = null;
        var loc = getClass().getResource("CurrencyWindow.fxml");
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file");
        }
        Scene windowContents = new Scene(root, 900,400);
        Stage recipeWindow = new Stage();
        recipeWindow.setScene(windowContents);
        recipeWindow.setTitle("Currency Exchange");
        recipeWindow.show();
    }

    // Weather Window
    @FXML
    public void openWeatherWindow(ActionEvent event) {
        Parent root = null;
        var loc = getClass().getResource("WeatherWindow.fxml");
        try {
            root = FXMLLoader.load(loc);

        } catch (IOException e) {
        }
    }
}