/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private ComboBox<?> cbxRol;
    @FXML
    private Button btnCrear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CerrarClick(ActionEvent event) {
        Stage stage = (Stage) this.btnCerrar.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void CrearClick(ActionEvent event) {
        if(txtNombre!=null && !txtNombre.getText().isEmpty() && txtContraseña!=null && !txtContraseña.getText().isEmpty() && cbxRol.getSelectionModel().getSelectedItem()!=null){
            
            //mandarConfirmacion(CONFIRMACION_USUARIO_CREAR_TITULO, CONFIRMACION_USUARIO_CREAR_TEXXTO);
            Stage stage = (Stage) this.btnCrear.getScene().getWindow();
            stage.close();
            
            
            
            
        }else{
            //mandarError(ERROR_CREAR_USUARIO_TITULO, ERROR_CREAR_USUARIO_TEXTO);
        }
    }
    
    
}
