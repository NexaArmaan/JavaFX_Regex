package com.example.javafx_regex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/example/javafx_regex/form.fxml"))));
        stage.setTitle("Registration Form");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}