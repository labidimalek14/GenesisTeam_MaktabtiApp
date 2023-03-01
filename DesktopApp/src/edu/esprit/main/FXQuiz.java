/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class FXQuiz extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/FXMLQuiz.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            // scene.getStylesheets().add("/edu/esprit/gui/styles/crud.css");
            primaryStage.getIcons().add(new Image("/edu/esprit/gui/images/icon-app-logo.png"));
            primaryStage.setTitle("Quiz");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
