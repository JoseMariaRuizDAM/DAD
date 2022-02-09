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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import recetasfx.modelo.DAO.UsuarioDao;
import recetasfx.modelo.connection.DbConnection;

/**
 * FXML Controller class
 *
 * @author Jose
 */
public class GestionUsuariosController implements Initializable {

    @FXML
    private HBox hboxTipoRecetas;
    @FXML
    private Button btnEditUser;
    @FXML
    private Button btnBorrarUser;
    @FXML
    private Button btnCrearUser;
    @FXML
    private TableView<?> tabla;
    @FXML
    private TableColumn<?, ?> columnNombre;
    @FXML
    private TableColumn<?, ?> ColumnContraseña;
    @FXML
    private TableColumn<?, ?> ColumRol;
    
    UsuarioDao usuarioDao;
    DbConnection db;
            

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db = new DbConnection();
        usuarioDao = new UsuarioDao(db);
        
        this.columnNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nick"));
        
        this.ColumnContraseña.setCellValueFactory(new PropertyValueFactory<Usuario, String>("pass"));
        
        this.ColumRol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("role"));
        
        
        //llenarLista();
        
        
        reloadTable();
        
        //this.tabla.setItems(getUsuarios());
    }    

    @FXML
    private void EditUserClick(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app_recetas/vista/ModificarUsuario.fxml"));
            Parent root = loader.load();
            EditarUsuarioController controller = loader.getController();
            
            controller.datosUsuario(tabla.getSelectionModel().getSelectedItem().getNick(),tabla.getSelectionModel().getSelectedItem().getPass(),tabla.getSelectionModel().getSelectedItem().getRole());
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
            
            //recargarTablaNuevosUser();
            
            
            
        } catch (IOException ex) {
            //Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage gestionUserStage = (Stage) this.btnCrearUser.getScene().getWindow();
        gestionUserStage.close();
        redirigirGestionUser();
    }

    @FXML
    private void BorrarUserClick(ActionEvent event) {
    }

    @FXML
    private void CrearUserClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/CrearUsuario.fxml"));
            Parent root = loader.load();
            CrearUsuarioController controller = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
        
                
        } catch (IOException ex) {
            //Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage gestionUserStage = (Stage) this.btnCrearUser.getScene().getWindow();
        gestionUserStage.close();
        redirigirGestionUser();
    }
    
    /**
     * Redirigo al usuario una vez finaliza sus acciones
     */
    public void redirigirGestionUser(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/DashboardPrincipal.fxml"));
            Parent root = loader.load();
            DashboardPrincipalController controller = loader.getController();
            //controller.setRecargarTablaUsuer();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
           // controller.cambiarStage();
        } catch (IOException ex) {
            Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
