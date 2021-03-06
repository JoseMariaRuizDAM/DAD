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
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class ModificarRecetaController implements Initializable {

    @FXML
    private ImageView imagen;
    @FXML
    private Button btnCerrar;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtAutor;
    @FXML
    private Slider SliderPasos;
    @FXML
    private Spinner<Integer> spinerComensales;
    @FXML
    private TextField txtCalorias;
    @FXML
    private TextField txtTiempo;
    @FXML
    private ComboBox<String> txtTipo;
    @FXML
    private TextArea txaIngredientes;
    @FXML
    private Button btnModificar;
    
    Receta receta;
    String nombre,autor,tipoReceta,ingredientes,imagenReceta;
    int calorias,comensales,pasos,tiempoPreparacion;

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
    private void ModificarClick(ActionEvent event) {
        if (!txtTitulo.getText().isEmpty() && !txtAutor.getText().isEmpty() && !txtCalorias.getText().isEmpty() && !txaIngredientes.getText().isEmpty() && !txtTipo.getValue().isEmpty() && txtTipo != null) {
            nombre = txtTitulo.getText();
            autor = txtAutor.getText();
            calorias = Integer.parseInt(txtCalorias.getText());
            tiempoPreparacion = Integer.parseInt(txtTiempo.getText());
            ingredientes = txaIngredientes.getText();
            pasos = (int) SliderPasos.getValue();
            comensales = spinerComensales.getValue();
            tipoReceta = txtTipo.getSelectionModel().getSelectedItem();
            
            Receta receta = new Receta(nombre,autor,tipoReceta,ingredientes,imagenReceta, pasos,comensales,tiempoPreparacion,calorias);
            DbConnection db = new DbConnection();
            RecetaDao recetaDao = new RecetaDao(db);
            try {
                recetaDao.update(receta);
            } catch (SQLException ex) {
                Logger.getLogger(ModificarRecetaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/CreadoModificadoDialogo.fxml"));
            Parent root = loader.load();
            CreadoModificadoDialogoController controller = loader.getController();
            controller.setTitulo(RECETA_TITULO_MODIFICADO);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            Stage stage = (Stage) this.btnCerrar.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error campos vacios");
            alert.showAndWait();
        }
    }
    
    public void getTitulo(String nombre){
        this.nombre = nombre;
        DbConnection db = new DbConnection();
        RecetaDao recetaDao = new RecetaDao(db);
        receta = recetaDao.select(nombre);
        txtTitulo.setText(receta.getNombre());
        txtAutor.setText(receta.getAutor());
        txtCalorias.setText("" + receta.getCalorias());
        txtTiempo.setText("" + receta.getTiempoPreparacion());
        txtTipo.setValue(receta.getTipoReceta());
        txaIngredientes.setText(receta.getIngredientes());
        SliderPasos.setValue(receta.getPasos());
        imagenReceta=receta.getImagen();
        Image img = new Image("recetasfx/imagenes/recetas/" + receta.getImagen());
        imagen.setImage(img);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20);
        valueFactory.setValue(receta.getComensales());        
        spinerComensales.setValueFactory(valueFactory);
        
    }
    
}
