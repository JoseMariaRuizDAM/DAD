/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
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
public class HomNuevoController implements Initializable {

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private VBox scroll;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnFiltrar;
    
    DbConnection db;
    ArrayList<Receta> listaRecetas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        db = new DbConnection();
        listaRecetas = new ArrayList<>();
        RecetaDao receta = new RecetaDao(db);
        listaRecetas = (ArrayList<Receta>) receta.selectAll();

        /*
        for (Receta r : listaRecetas) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/RecetaInfo.fxml"));
            //ItemController controller = loader.getController();
            RecetaInfoController controller = new RecetaInfoController();
            controller.añadirInformacion(r.getNombre(), r.getTipoReceta(), r.getTiempoPreparacion(), r.getComensales());
            loader.setController(controller);

            try {
                scroll.getChildren().add((Node) loader.load());
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }    

    /**
     * Función que se ejecuta cuando se presiona en el boton agregar
     * de la vista. Abre una nueva ventana, donde se creara una nueva receta
     * @param event 
     */
    @FXML
    private void AgregarRec(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/recetasfx/vista/CrearReceta.fxml"));
            Parent root = loader.load();
            CrearRecetaController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(recetasfx.controlador.HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
