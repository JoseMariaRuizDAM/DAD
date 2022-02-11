/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class CrearRecetaController implements Initializable {

    String nombre,tipoReceta,autor,ingredientes,imagen;
    int pasos,comensales,tiempoReceta,calorias;
    
    Stage stage;
    private Button cerrarBtn;
    private TextField txtNombre;
    @FXML
    private TextField txtAutor;
    @FXML
    private TextField txtCalorias;
    @FXML
    private TextField txtTiempo;
    private TextArea txtIngredientes;
    @FXML
    private Button btnCerrar;
    @FXML
    private TextField txtTitulo;
    @FXML
    private Slider SliderPasos;
    @FXML
    private Spinner<Integer> spinerComensales;
    @FXML
    private ComboBox<String> txtTipo;
    @FXML
    private TextArea txaIngredientes;
    @FXML
    private Button btnCrear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void cerrarClick(ActionEvent event) {
        stage = (Stage) this.cerrarBtn.getScene().getWindow();
        stage.close();
    }

    private void CrearRecetaClick(ActionEvent event) {
        DbConnection db = new DbConnection();
        RecetaDao recetaDao = new RecetaDao(db);

        if (!txtNombre.getText().isEmpty() &&
                !txtAutor.getText().isEmpty() &&
                !txtCalorias.getText().isEmpty() &&
                !txtIngredientes.getText().isEmpty() &&
                !txtTipo.getValue().isEmpty() &&
                txtTipo != null) {
            
            nombre = txtNombre.getText();
            autor = txtAutor.getText();
            calorias = Integer.parseInt(txtCalorias.getText());
            tiempoReceta = Integer.parseInt(txtTiempo.getText());
            ingredientes = txtIngredientes.getText();
            pasos = (int) SliderPasos.getValue();
            comensales = spinerComensales.getValue();
            tipoReceta = txtTipo.getSelectionModel().getSelectedItem();

            imagen = "food-fork-drink.png";

            Receta receta = new Receta(nombre, autor, tipoReceta, ingredientes, imagen, pasos, comensales, tiempoReceta, calorias);
            try {
                recetaDao.insert(receta);
            } catch (SQLException ex) {
                Logger.getLogger(CrearRecetaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app_recetas/vista/CreadoModificadoDialogo.fxml"));
            Parent root = loader.load();
            CreadoModificadoDialogoController controller = loader.getController();
            controller.setTitulo(RECETA_TITULO_CREADO);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        Stage stagecrear = (Stage) this.cerrarBtn.getScene().getWindow();
        stagecrear.close();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error campos vacios");
            alert.showAndWait();
        }
    }

    @FXML
    private void CrearClick(ActionEvent event) {
        
        DbConnection db = new DbConnection();
        RecetaDao recetaDao = new RecetaDao(db);

        if (!txtTitulo.getText().isEmpty() && !txtAutor.getText().isEmpty() && !txtCalorias.getText().isEmpty() && !txaIngredientes.getText().isEmpty() && !txtTipo.getValue().isEmpty() && txtTipo != null) {
            nombre = txtTitulo.getText();
            autor = txtAutor.getText();
            calorias = Integer.parseInt(txtCalorias.getText());
            tiempoReceta = Integer.parseInt(txtTiempo.getText());
            ingredientes = txaIngredientes.getText();
            pasos = (int) SliderPasos.getValue();
            comensales = spinerComensales.getValue();
            tipoReceta = txtTipo.getSelectionModel().getSelectedItem();

            imagen = "food-fork-drink.png";

            Receta receta = new Receta(nombre, autor, tipoReceta, ingredientes, imagen, pasos, comensales, tiempoReceta, calorias);
            try {
                recetaDao.insert(receta);
            } catch (SQLException ex) {
                Logger.getLogger(CrearRecetaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app_recetas/vista/CreadoModificadoDialogo.fxml"));
            Parent root = loader.load();
            CreadoModificadoDialogoController controller = loader.getController();
            controller.setTitulo(RECETA_TITULO_CREADO);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        Stage stagecrear = (Stage) this.btnCerrar.getScene().getWindow();
        stagecrear.close();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error campos vacios");
            alert.showAndWait();
        }
    }

    @FXML
    private void CerrarClick(ActionEvent event) {
        Stage stage = (Stage) this.btnCerrar.getScene().getWindow();
        stage.close();
    }
    
}
