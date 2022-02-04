/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import recetasfx.modelo.entities.Usuario;
import recetasfx.modelo.DAO.UsuarioDao;
import java.io.File;
import java.io.IOException;
import recetasfx.controlador.DashboardPrincipalController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import recetasfx.modelo.utils.FileManagers.FileManagerUsuarios;

/**
 *
 * @author Jose
 */
public class LoginController implements Initializable {
    
    private Label label;
    @FXML
    private Button login_btn;
    @FXML
    private TextField user_login;
    @FXML
    private PasswordField password_login;
    
    FileManagerUsuarios fm;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * Función que se ejecuta cuando se presiona el botón entrar
     * Hara que se habra una nueva ventana según el rol que recoje
     * del usuario en el textBox usuario
     * @param event 
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String rol = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/DashboardPrincipal.fxml"));

        Parent root = loader.load();
        DashboardPrincipalController contPrincipal = loader.getController();
        
        if(password_login.getText()!=null &&
                !password_login.getText().isEmpty() &&
                user_login.getText()!=null &&
                !user_login.getText().isEmpty()){
            
            
            for (Usuario u : fm.loginUsuarios()) {    
            
                if(u.getUser().equals(user_login.getText()) && u.getPassword().equals(password_login.getText())){
                    
                    rol = u.getRol();

                    //Comprueba que el rol no es nulo y abre una pantalla según el rol
                    if(rol != null){
                        System.out.println("Bienvenido " + rol);                
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.show(); //Mostrar el stage DashboardPrincipalFXML
                    }
                 
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("¡Error!");
                    alert.setContentText("Usuario o contraseña no válido.");
                }
            }
        }
    } 
}
    
