package bsu.comp152;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file!!!!!!");
        }

        VBox box = new VBox();

        var text = new Label("Which option would like to chose, ");
        var color = Paint.valueOf("Red");
        text.setTextFill(color);
        var font = Font.font(20);
        text.setFont(font);
       // root.getChildren().add(text);
       // root.setSpacing(20);
        //var loc
        Button A = new Button("Jokes");  //Aman
        Button B = new Button("Star War");  // Richard
        Button C = new Button("Currency");
        Button D = new Button("Weather");

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent event){

            }
        };
        var firstScene = new Scene(box, 700,700) ;
        A.setOnAction(handler);
        A.setFont(font);
        primaryStage.setScene(firstScene);
        primaryStage.show();

    }
}
