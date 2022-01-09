/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import recetasfx.modelo.entities.Receta;

/**
 * FXML Controller class
 *
 * @author Jose
 */
public class PrincipalFXMLController implements Initializable {

    @FXML
    private Button home_btn;
    @FXML
    private Button inNutri_btn;
    @FXML
    private Button busRecetas_btn;
    @FXML
    private Button estadisticas_btn;
    @FXML
    private Button gestionUsuarios_btn;
    @FXML
    private Button ponNotas_btn;
    @FXML
    private TableView<Receta> tableRecetas;
    
    @FXML
    private TextField buscar_text;
    @FXML
    private TableColumn<Receta, String> titleColumn;
    @FXML
    private TableColumn<Receta, String> typeColumn;
    @FXML
    private TableColumn<Receta, Integer> dinersColumn;
    @FXML
    private TableColumn<Receta, Integer> timeColumn;
    @FXML
    private TableColumn<Receta, Integer> caloriesColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
