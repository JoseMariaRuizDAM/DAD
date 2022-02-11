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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import recetasfx.modelo.DAO.RecetaDao;
import recetasfx.modelo.connection.DbConnection;
import recetasfx.modelo.entities.Receta;

/**
 * FXML Controller class
 *
 * @author Jose
 */
public class RecetaDetalleController implements Initializable {

    @FXML
    private ImageView imgReceta;
    @FXML
    private Label TituloReceta;
    @FXML
    private Button btnCerrar;
    @FXML
    private Label lblAutor;
    @FXML
    private ImageView imgTipo;
    @FXML
    private Label lblTipo;
    @FXML
    private Label lblTiempo;
    @FXML
    private Label lblCalorias;
    @FXML
    private Label lblPasos;
    @FXML
    private Label lblComensales;
    @FXML
    private Label lblIngredientes;
    @FXML
    private Button btnAceptar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CerrarClick(ActionEvent event) {
    }

    @FXML
    private void AceptarClick(ActionEvent event) {
    }
    
    public void ponerDatos(String titulo){
        DbConnection db = new DbConnection();
        RecetaDao recetaDao = new RecetaDao(db);
        Receta r = recetaDao.select(titulo);
        
        TituloReceta.setText(titulo);
        lblAutor.setText(r.getAutor());
        lblCalorias.setText("" + r.getCalorias());
        lblComensales.setText("" + r.getComensales());
        lblIngredientes.setText(r.getIngredientes());
        lblPasos.setText("" + r.getPasos());
        lblTiempo.setText("" + r.getTiempoPreparacion());
        lblTipo.setText(r.getTipoReceta());
        
       if(r.getImagen() != null && !r.getImagen().isEmpty()){
            Image imagen = new Image("recetasfx/imagenes/recetas/" + r.getImagen());
            imgReceta.setImage(imagen);
            Image img = new Image("recetasfx/imagenes/recetas/tipos/" + r.getTipoReceta() + ".png");
            imgTipo.setImage(img);
        }else{
           Image imagen = new Image("recetasfx/imagenes/item/food-fork-drink.png");
           imgReceta.setImage(imagen);
           Image img = new Image("recetasfx/imagenes/recetas/tipos/" + r.getTipoReceta()+".png");
            imgTipo.setImage(img);
        }
    }
}
