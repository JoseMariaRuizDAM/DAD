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
import javafx.scene.Node;
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
    @FXML
    private Button homeBoton;
    @FXML
    private Button InformacionBoton;
    @FXML
    private Button BuscadorBoton;
    @FXML
    private Button NotasBoton;
    @FXML
    private Button UsuarioBoton;
    @FXML
    private Button EstadisticaBoton;
    
    String rol;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {       
            Node node = (Node)FXMLLoader.load(getClass().getResource("/recetasfx/vista/Home.fxml"));
            panel.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(DashboardPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }   
    
    /**
     * Evento onClick para ir al home
     * @param event 
     */
    @FXML
    private void HomeBoton(ActionEvent event) {
        
        try {
            panel.getChildren().clear();
            Node node = (Node)FXMLLoader.load(getClass().getResource("/recetasfx/vista/Home.fxml"));
            panel.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(DashboardPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Evento onClick para ir al InfNutricional
     * @param event 
     */
    @FXML
    private void InformacionBoton(ActionEvent event) {
        
        try {       
            panel.getChildren().clear();
            Node node = (Node)FXMLLoader.load(getClass().getResource("/recetasfx/vista/Working.fxml"));
            panel.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(DashboardPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Evento onClick para ir al Buscador de receta
     * @param event 
     */
    @FXML
    private void BuscadorBoton(ActionEvent event) {
         try {       
            panel.getChildren().clear();
            Node node = (Node)FXMLLoader.load(getClass().getResource("/recetasfx/vista/Working.fxml"));
            panel.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(DashboardPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Evento onClick para ir al Notas
     * @param event 
     */
    @FXML
    private void NotasBoton(ActionEvent event) {
        try {       
            panel.getChildren().clear();
            Node node = (Node)FXMLLoader.load(getClass().getResource("/recetasfx/vista/Working.fxml"));
            panel.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(DashboardPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void UsuarioBoton(ActionEvent event) {
        
        try {       
            panel.getChildren().clear();
            Node node = (Node)FXMLLoader.load(getClass().getResource("/recetasfx/vista/GestionUsuario.fxml"));
            panel.getChildren().add(node);
        } catch (IOException ex) {
            Logger.getLogger(DashboardPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void EstadisticaBoton(ActionEvent event) {
        
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/Login.fxml"));
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
