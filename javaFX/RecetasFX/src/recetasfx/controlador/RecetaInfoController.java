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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import recetasfx.modelo.DAO.RecetaDao;
import recetasfx.modelo.connection.DbConnection;
import recetasfx.modelo.entities.Receta;

/**
 * FXML Controller class
 *
 * @author Jose
 */
public class RecetaInfoController implements Initializable {

    @FXML
    private ImageView imgReceta;
    @FXML
    private Label txtTitulo;
    @FXML
    private ImageView ImgTipo;
    @FXML
    private Label txtTipo;
    @FXML
    private Label txtTiempo;
    @FXML
    private Label txtComensales;
    @FXML
    private Button btnAcceder;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnBorrar;
    
    String nombre,tipoReceta;
    int tiempoPreparacion,comensales;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTitulo.setText(nombre);
        txtTipo.setText(tipoReceta);
        txtTiempo.setText("" + tiempoPreparacion);
        txtComensales.setText("" + comensales);
        
        DbConnection db = new DbConnection();
        RecetaDao recetaDao = new RecetaDao(db);
        Receta r = recetaDao.select(nombre);
        
       
        Image imagen = new Image("recetasfx/icons/food.png");
        imgReceta.setImage(imagen);
            
    }    
    
    

     /**
     * Función que se ejecuta cuando se hace click
     * en la reeta para acceder a la informacion de
     * de la receta que se ha presionado
     * @param event 
     */
    @FXML
    private void AccederClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/RecetaDetalle.fxml"));
            Parent root = loader.load();
            RecetaDetalleController controller = loader.getController();
            controller.ponerDatos(this.txtTitulo.getText());
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(RecetaInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Función que se ejecuta cuando
     * se presiona en el botón de editar,
     * abrira una nueva vista con la ventana
     * para modificar la receta.
     * @param event 
     */
    @FXML
    private void EditarClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/ModificarReceta.fxml"));
            Parent root = loader.load();
            ModificarRecetaController controller = loader.getController();

            controller.getTitulo(nombre);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            //Logger.getLogger(BorrarRecetaDialogoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage gestionRecetaStage = (Stage) this.btnBorrar.getScene().getWindow();
        gestionRecetaStage.close();
        volverHome();
    }

    /**
     * Función que se ejecuta cuando se hace click
     * en el botón de borrar
     * @param event 
     */
    @FXML
    private void BorrarClick(ActionEvent event) {
        Stage gestionRecetaStage = (Stage) this.btnBorrar.getScene().getWindow();
        gestionRecetaStage.close();
        volverHome();        
    }
    
    /**
     * Metodo para crear la informacion del item visual
     * @param titulo
     * @param tipo
     * @param tiempo
     * @param comensales 
     */
    public void añadirInformacion(String nombre,String tipoReceta,int tiempoPreparacion,int comensales){
        
        this.nombre = nombre;
        this.tipoReceta = tipoReceta;
        this.tiempoPreparacion = tiempoPreparacion;
        this.comensales = comensales;
    }
    
    /**
     * Metodo para volver a la Home
     * cuando termine una acción que ha ejecutado
     */
    public void volverHome(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/DashboardPrincipal.fxml"));
            Parent root = loader.load();
            DashboardPrincipalController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();           
        } catch (IOException ex) {
            Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
}
