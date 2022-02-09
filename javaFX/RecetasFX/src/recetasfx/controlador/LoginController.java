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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import recetasfx.modelo.connection.DbConnection;
/**
 *
 * @author Jose
 */
public class LoginController implements Initializable {
    
    private Stage stage = null;
    private Label label;
    @FXML
    private Button login_btn;
    @FXML
    private TextField user_login;
    @FXML
    private PasswordField password_login;
    
    DbConnection db;
    Usuario user;
    UsuarioDao userDao;
    String rol;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db = new DbConnection();
        userDao = new UsuarioDao(db);
    }    
    
    /**
     * Función que se ejecuta cuando se presiona el botón entrar
     * Hara que se habra una nueva ventana según el rol que recoje
     * del usuario en el textBox usuario
     * @param event 
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(password_login.getText()!=null&& !password_login.getText().isEmpty() 
                && user_login.getText()!=null && !user_login.getText().isEmpty()){
            System.out.println(user_login.getText());
            user = userDao.select(user_login.getText());
            if(user != null){
                if(user.getPassword().equals(password_login.getText())){
                    rol = user.getRol();
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/DashboardPrincipal.fxml"));
                        DashboardPrincipalController controller = new DashboardPrincipalController();
                        controller.setRol(rol);
                        loader.setController(controller);
                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        stage = new Stage();
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setScene(scene);
                        stage.show();
                        
                        Stage mystage = (Stage) this.login_btn.getScene().getWindow();
                        mystage.close();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    login_btn.setText("");
                    password_login.setText("");
                    //mandarError(ERROR_LOGIN_NOENCONTRADO_TITULO,ERROR_LOGIN_NOENCONTRADO_TEXTO);
                    System.out.println("Error usuario no encontrado");
                }
            }
        }else{
            user_login.setText("");
            password_login.setText("");
            //mandarError(ERROR_LOGIN_VACIO_TITULO,ERROR_LOGIN_VACIO_TEXTO);
            System.out.println("Error campos vacios");
        }       
    }
}    

    
