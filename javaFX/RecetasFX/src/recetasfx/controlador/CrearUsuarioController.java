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
public class CrearUsuarioController implements Initializable {

    @FXML
    private Button btnCerrar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtContraseña;
    @FXML
    private ComboBox<String> cbxRol;
    @FXML
    private Button btnCrear;
    DbConnection db = new DbConnection();
    Usuario user = new Usuario();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList list = FXCollections.observableArrayList("Alumno","Profesor");
        cbxRol.setItems(list);
    }    

    /**
     * Función para cerrar esta pantalla cuando se presiona en el botón cerrar
     * Recoge los datos que se han añadido en los textFields
     * @param event 
     */
    @FXML
    private void CerrarClick(ActionEvent event) {
        Stage stage = (Stage) this.btnCerrar.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Función para crear un usuario cuando se presiona en el botón crear
     * Recoge los datos que se han añadido en los textFields
     * @param event 
     */
    @FXML
    private void CrearClick(ActionEvent event) {
        if(txtNombre != null && !txtNombre.getText().isEmpty() &&
            txtContraseña != null && !txtContraseña.getText().isEmpty() &&
            cbxRol.getSelectionModel().getSelectedItem() != null){
            
            UsuarioDao userDao = new UsuarioDao(db);
            try {
                user.setUser(txtNombre.getText());
                user.setPassword(txtContraseña.getText());
                user.setRol(cbxRol.getSelectionModel().getSelectedItem());
                userDao.insert(user);
            } catch (SQLException ex) {
                Logger.getLogger(CrearUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = (Stage) this.btnCrear.getScene().getWindow();
            stage.close();
        }else{
            
        }
    }
}
