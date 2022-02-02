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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/DashboardPrincipal.fxml"));

                    Parent root = loader.load();
                    DashboardPrincipalController contPrincipal = loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setScene(scene);
                    stage.show(); //Mostrar el stage PrincipalFXML


                }catch(IOException e){
                    e.printStackTrace();
                }
        /*
        if(password_login.getText()!=null&& !password_login.getText().isEmpty() && user_login.getText()!=null && !user_login.getText().isEmpty()){
            Usuario user = new Usuario(user_login.getText(), password_login.getText()); 
            UsuarioDao login = new UsuarioDao();
            rol = login.UserLogin(user);
            //Comprueba que el rol no es nulo y abre una pantalla según el rol
            if(rol != null){
                System.out.println("Bienvenido " + rol);
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/DashboardPrincipal.fxml"));

                    Parent root = loader.load();
                    DashboardPrincipalController contPrincipal = loader.getController();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.show(); //Mostrar el stage PrincipalFXML


                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }*/
        // Inicio de la ventana Principal cuando hace click en el botón 
        
    }
}
    
