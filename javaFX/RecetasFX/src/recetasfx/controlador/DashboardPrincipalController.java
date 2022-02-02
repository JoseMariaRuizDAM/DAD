/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Jose
 */
public class DashboardPrincipalController implements Initializable {

    Stage stage;
    @FXML
    private Button cerrarVentanaBoton;
    @FXML
    private Button minVentana;
    @FXML
    private Button maxVentana;
    @FXML
    private Button cerrarSesion;
    @FXML
    private Pane panel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    /**
     * Evento onClick para cerrar el stage
     * @param event 
     */
    @FXML
    private void cerrarVentanaBoton(ActionEvent event){
        stage = (Stage) this.cerrarVentanaBoton.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Evento onClick para minimizar el stage
     * @param event 
     */
    @FXML
    private void minVentana(ActionEvent event) {
        stage = (Stage)this.minVentana.getScene().getWindow();
        stage.setIconified(true);
    }

    /**
     * Evento onClick para maximizar el stage
     * @param event 
     */
    @FXML
    private void maxVentana(ActionEvent event) {
        stage = (Stage)this.maxVentana.getScene().getWindow();
        stage.setMaximized(!stage.isMaximized());
    }
    
    /**
     * Evento onClick para cerrar sesion
     * @param event 
     */
    @FXML
    private void cerrarSesion(ActionEvent event) {
        stage = (Stage) this.cerrarSesion.getScene().getWindow();
        stage.close();
        try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RecetasFX/vista/Login.fxml"));
                        Parent root = loader.load();
                        LoginController controller = loader.getController();

                        Scene scene = new Scene(root);
                        stage = new Stage();
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setScene(scene);
                        stage.show();
                        
                       
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
    }    
}
