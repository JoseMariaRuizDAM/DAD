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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.SpinnerValueFactory;
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
    @FXML
    private TextField txtAutor;
    @FXML
    private TextField txtCalorias;
    @FXML
    private TextField txtTiempoPreparacion;
    @FXML
    private Button btnCerrar;
    @FXML
    private TextField txtNombre;
    @FXML
    private Slider SliderPasos;
    @FXML
    private Spinner<Integer> spinerComensales;
    @FXML
    private ComboBox<String> txtTipoReceta;
    @FXML
    private TextArea txtIngredientes;
    @FXML
    private Button btnCrear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20);
        valueFactory.setValue(1);
        
        spinerComensales.setValueFactory(valueFactory);
        
        ObservableList list = FXCollections.observableArrayList("Entrante","Primero","Segundo","Postre");
        txtTipoReceta.setItems(list);
        txtTipoReceta.getSelectionModel().select(0);
    }    

    private void cerrarClick(ActionEvent event) {
        stage = (Stage) this.cerrarBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void CrearClick(ActionEvent event) {
        
        DbConnection db = new DbConnection();
        RecetaDao recetaDao = new RecetaDao(db);

        if (!txtNombre.getText().isEmpty() && !txtAutor.getText().isEmpty() 
                && !txtCalorias.getText().isEmpty() && !txtIngredientes.getText().isEmpty() 
                && !txtTipoReceta.getValue().isEmpty() && txtTipoReceta != null) {
            nombre = txtNombre.getText();
            autor = txtAutor.getText();
            calorias = Integer.parseInt(txtCalorias.getText());
            tiempoReceta = Integer.parseInt(txtTiempoPreparacion.getText());
            ingredientes = txtIngredientes.getText();
            pasos = (int) SliderPasos.getValue();
            comensales = spinerComensales.getValue();
            tipoReceta = txtTipoReceta.getSelectionModel().getSelectedItem();

            imagen = "food.png";

            Receta receta = new Receta(nombre, autor, tipoReceta, ingredientes, imagen, pasos, comensales, tiempoReceta, calorias);
            try {
                recetaDao.insert(receta);
            } catch (SQLException ex) {
                Logger.getLogger(CrearRecetaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = (Stage) this.btnCrear.getScene().getWindow();
            stage.close();

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
