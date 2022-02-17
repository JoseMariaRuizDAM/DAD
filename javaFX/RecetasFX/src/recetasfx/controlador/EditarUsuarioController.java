/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import recetasfx.modelo.DAO.UsuarioDao;
import recetasfx.modelo.connection.DbConnection;
import recetasfx.modelo.entities.Usuario;

/**
 * FXML Controller class
 *
 * @author Jose
 */
public class EditarUsuarioController implements Initializable {
    
    String nick,pass,rol;
    DbConnection db;

    @FXML
    private Button btnCerrar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtContraseña;
    @FXML
    private ComboBox<String> cbxRol;
    @FXML
    private Button btnModificar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList list = FXCollections.observableArrayList("Alumno","Profesor");
       cbxRol.setItems(list);
       db = new DbConnection();
    }    

    @FXML
    private void CerrarClick(ActionEvent event) {
        Stage stage = (Stage) this.btnCerrar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ModificarClick(ActionEvent event) {
        
        if(txtNombre.getText()!= null && !txtNombre.getText().isEmpty() 
                && txtContraseña.getText()!= null && !txtContraseña.getText().isEmpty() 
                && cbxRol.getSelectionModel().getSelectedItem()!= null){
            try {
                Usuario modificado = new Usuario(txtNombre.getText(),txtContraseña.getText(),cbxRol.getSelectionModel().getSelectedItem());
                UsuarioDao userDao = new UsuarioDao(db);
                userDao.update(modificado);
                Stage stage = (Stage) this.btnCerrar.getScene().getWindow();
                stage.close();
            } catch (SQLException ex) {
                Logger.getLogger(EditarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }else{
            
        }
    }
    
    public void datosUsuario(String nick,String pass, String rol){
        txtNombre.setText(nick);
        txtContraseña.setText(pass);
        cbxRol.getSelectionModel().select(rol);
        
        
    }
    
}
