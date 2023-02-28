/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;
import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;
import edu.esprit.services.ServiceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import edu.esprit.entities.Utilisateur;
import edu.esprit.util.DataSource;
import edu.esprit.entities.login;
import java.sql.Connection;

/**
 * FXML Controller class
 *
 * @author wassi
 */
public class AuthentificationController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Connection cnx = DataSource.getInstance().getCnx();
    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private Button reset;
    @FXML
    private Button Logiiin;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    

    @FXML
    private void login(ActionEvent event) throws IOException {
        login Log_in = login.getInstance();
        ServiceUtilisateur su = new ServiceUtilisateur();
        
        Utilisateur u = su.getuserbyemailandpass(username.getText(), password.getText());
        if (username.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Email ne doit pas etre vide!", ButtonType.OK);
            a.showAndWait(); 
        } else if (password.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Mot de passe ne doit pas etre vide!", ButtonType.OK);
            a.showAndWait(); 
        }else{
        if (u.getMot_de_passe().equals(password.getText()) || u.getEmail().equals(username.getText()) ) {
        System.out.println(u.getRole());
        Log_in.setUsername(u.getEmail());
        Log_in.setPassword(u.getMot_de_passe());
        System.out.println(Log_in.getPassword());
        System.out.println(Log_in.getUsername());
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Authentified Succefully!", ButtonType.OK);
            a.showAndWait(); 
        Parent root = FXMLLoader.load(getClass().getResource("Utilisateur.fxml"));
        Scene homaepageScene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(homaepageScene);
        appStage.show();
        } 
    }

    }


    
    /***********************************************/
         private boolean Validateemail() {
        Pattern p = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher m = p.matcher(username.getText());
        if (((username.getText().length() > 8))&& (m.find() && m.group().equals(username.getText()))) {
            username.setEffect(null);
            return true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Email Invalide", ButtonType.OK);
            a.showAndWait();
            return false;
        }
    }
     
    

    private boolean Validatemotdepasse() {
        Pattern p = Pattern.compile("[a-zA-Z_0-9]+");
        Matcher m = p.matcher(username.getText());
                if (((username.getText().length() > 7))
                && (m.find() && m.group().equals(username.getText()))) {
            username.setEffect(null);
            return true;
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Mot de passe invalide", ButtonType.OK);
            a.showAndWait();
            return false;
        }
        
    }



    @FXML
    private void registrationpage(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void reset(ActionEvent event) {
        password.setText(null);
        username.setText(null);
    }


}
