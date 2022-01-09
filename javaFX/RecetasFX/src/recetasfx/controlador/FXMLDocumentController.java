/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import java.io.File;
import java.io.IOException;
import recetasfx.controlador.PrincipalFXMLController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Jose
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button login_btn;
    @FXML
    private TextField user_login;
    @FXML
    private PasswordField password_login;
    
    /**
     * Función que se ejecuta cuando se presiona el botón entrar
     * Hara que se habra una nueva ventana según el rol que recoje
     * del usuario en el textBox usuario
     * @param event 
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Bienvenido");
        // Inicio de la ventana Principal cuando hace click en el botón 
        try{
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/PrincipalFXML.fxml"));
        
            Parent root = loader.load();
            PrincipalFXMLController contPrincipal = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show(); //Mostrar el stage PrincipalFXML

            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
