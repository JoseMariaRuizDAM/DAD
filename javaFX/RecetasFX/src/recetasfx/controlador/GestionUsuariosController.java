/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import recetasfx.modelo.entities.Usuario;

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
    private TableView<Usuario> tabla;
    @FXML
    private TableColumn<Usuario, String> columnNombre;
    @FXML
    private TableColumn<Usuario, String> ColumnContraseña;
    @FXML
    private TableColumn<Usuario, String> ColumRol;
    
    UsuarioDao usuarioDao;
    DbConnection db;
    private ArrayList<Usuario> usuarios;
    String nombreUsuario;
            

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db = new DbConnection();
        usuarioDao = new UsuarioDao(db);
        
        this.columnNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("User"));
        
        this.ColumnContraseña.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Password"));
        
        this.ColumRol.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Rol"));
        
        
        //llenarLista();
        
        
        reloadTable();
        
        //this.tabla.setItems(getUsuarios());
    }    

    @FXML
    private void EditUserClick(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/EditarUsuario.fxml"));
            Parent root = loader.load();
            EditarUsuarioController controller = loader.getController();
            
            controller.datosUsuario(tabla.getSelectionModel().getSelectedItem().getUser(),
                tabla.getSelectionModel().getSelectedItem().getPassword(),
                tabla.getSelectionModel().getSelectedItem().getRol());
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
            
            recargarTablaNuevosUser();
            
            
            
        } catch (IOException ex) {
            //Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*Stage gestionUserStage = (Stage) this.btnCrearUser.getScene().getWindow();
        gestionUserStage.close();*/
        recargarTablaNuevosUser();
        redirigirGestionUser();
    }

    @FXML
    private void BorrarUserClick(ActionEvent event) {
        
        try {
            nombreUsuario = tabla.getSelectionModel().getSelectedItem().getUser();
            UsuarioDao userDao = new UsuarioDao(db);
            
            userDao.delete(nombreUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        //redirigirGestionUser();
    }
    
    /**
     * Redirigo al usuario una vez finaliza cualquier acción que ejecute
     */
    public void redirigirGestionUser(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/DashboardPrincipal.fxml"));
            Parent root = loader.load();
            DashboardPrincipalController controller = loader.getController();
            //controller.setRecargarTablaUser();

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
    
    /**
     * Obtengo la lista de usuarios en formato observable
     * @return 
     */
    public ObservableList<Usuario> getUsuarios(){
        ObservableList<Usuario> obs = FXCollections.observableArrayList();
        usuarios = (ArrayList<Usuario>) usuarioDao.selectAll();
        
        for (int i = 0; i < usuarios.size(); i++) {
            obs.add(usuarios.get(i));
        }        
        return obs;
    }
    
    /**
     * Metodo para recargar la tabla
     */
    public void reloadTable(){
        getUsuarios();
        tabla.setItems(FXCollections.observableList(usuarios));
    }
    
    /**
 * Metodo para recargar la tabla de usuatios
 */
    public void recargarTablaNuevosUser(){
        ObservableList<Usuario> obs = FXCollections.observableArrayList();
        UsuarioDao listauser = new UsuarioDao(db);
        
        ArrayList<Usuario> listau = (ArrayList<Usuario>) listauser.selectAll();
        
        for (int i = 0; i < listau.size(); i++) {

            obs.add(listau.get(i));
            System.out.println(""+listau.get(i).getUser());
        }
        
        
        tabla.setItems(FXCollections.observableList(listau));
        
        
    }

}
