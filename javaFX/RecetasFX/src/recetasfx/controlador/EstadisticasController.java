/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import recetasfx.modelo.DAO.RecetaDao;
import recetasfx.modelo.connection.DbConnection;
import recetasfx.modelo.entities.Receta;

/**
 * FXML Controller class
 *
 * @author Jose
 */
public class EstadisticasController implements Initializable {

    @FXML
    private Pane panelSector;
    @FXML
    private PieChart pieChart;
    @FXML
    private Button btnCalorias;
    @FXML
    private Button btnTipoRecetas;
    @FXML
    private HBox hboxTipoRecetas;
    @FXML
    private Button btnBarras;
    @FXML
    private Button btnSector;
    @FXML
    private Pane panelTipoReceta;
    @FXML
    private BarChart<?, ?> TipoRecetasBarChar;
    @FXML
    private Pane panelBarras;
    @FXML
    private BarChart<?, ?> barchar;
    @FXML
    private Label labelInfo;
    @FXML
    private ImageView img;
    
    ArrayList<Receta> list;
    double caloriasMedia;
    int numTotal;
    int numEntrantes=0;
    int numPrimeros=0;
    int numSegundos=0;
    int numPostres=0;    
    XYChart.Series postres;
    XYChart.Series entrantes;
    XYChart.Series primeros;
    XYChart.Series segundos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       CrearBarChart();
       CrearPieChart();
       GraficoTipoRecetas();
       calcularCaloriasMedia();
       panelBarras.setVisible(true);
       panelSector.setVisible(false);
       panelTipoReceta.setVisible(false);
    }    

    /**
     * Metodo para llenar la seccion entrantes para las estadisticas
     */
    public void llenarEntrantes(){
        DbConnection db = new DbConnection();
        RecetaDao receta = new RecetaDao(db);
        ArrayList<Receta> lista;
        String tipo="Entrante";
        
        lista = (ArrayList<Receta>) receta.selectByTipo(tipo);
        entrantes = new XYChart.Series<>();
        entrantes.setName(tipo);
        numEntrantes=lista.size();
        for (int i = 0; i<lista.size(); i++) {
            entrantes.getData().add(new XYChart.Data(lista.get(i).getNombre(),lista.get(i).getCalorias()));
            
        } 
    }
    /**
     * Metodo para llenar la seccion primeros para las estadisticas
     */
    public void llenarPrimero(){
        DbConnection db = new DbConnection();
        RecetaDao receta = new RecetaDao(db);
        ArrayList<Receta> lista;
        String tipo="Primero";
        
        lista = (ArrayList<Receta>) receta.selectByTipo(tipo);
        primeros = new XYChart.Series<>();
        primeros.setName(tipo);
        numPrimeros=lista.size();
        for (int i = 0; i<lista.size(); i++) {
            primeros.getData().add(new XYChart.Data(lista.get(i).getNombre(),lista.get(i).getCalorias()));
            
        } 
    }
    /**
     * Metodo para llenar la seccion segundos para las estadisticas
     */
    public void llenarSegundos(){
        DbConnection db = new DbConnection();
        RecetaDao receta = new RecetaDao(db);
        ArrayList<Receta> lista;
        String tipo="Segundo";
        
        lista = (ArrayList<Receta>) receta.selectByTipo(tipo);
        segundos = new XYChart.Series<>();
        segundos.setName(tipo);
        numSegundos=lista.size();
        for (int i = 0; i<lista.size(); i++) {
            segundos.getData().add(new XYChart.Data(lista.get(i).getNombre(),lista.get(i).getCalorias()));
        } 
    }
    /**
     * Metodo para llenar la seccion postres para las estadisticas
     */
    public void llenarPostres(){
        DbConnection db = new  DbConnection();
        RecetaDao receta = new RecetaDao(db);
        ArrayList<Receta> lista;
        String tipo="Postre";
        
        lista = (ArrayList<Receta>) receta.selectByTipo(tipo);
        postres = new XYChart.Series<>();
        postres.setName(tipo);
        numPostres=lista.size();
        for (int i = 0; i<lista.size(); i++) {
            postres.getData().add(new XYChart.Data(lista.get(i).getNombre(),lista.get(i).getCalorias()));
            
        } 
    }
    /**
     * Metodo para crear el BarChart
     */
    public void CrearBarChart(){
        llenarEntrantes();
        llenarPrimero();
        llenarSegundos();
        llenarPostres();
        barchar.getData().addAll(entrantes,primeros,segundos,postres);
    }
    /**
     * Metodo para crear el PieChart
     */
    public void CrearPieChart(){
        ObservableList<PieChart.Data> pierCharData = FXCollections.observableArrayList();
        DbConnection db = new DbConnection();
        RecetaDao receta = new RecetaDao(db);
        ArrayList<Receta> lista;
        lista = (ArrayList<Receta>) receta.selectAll();
        list = lista;
        numTotal=lista.size();
       
        for (int i = 0; i<lista.size(); i++) {
            pierCharData.add(new PieChart.Data(lista.get(i).getNombre(),lista.get(i).getCalorias()));
            
        } 
        pieChart.setData(pierCharData);
        pieChart.setTitle("Calorias por receta");
       
    }
    
    /**
     * 
     * Metodo para crear el grafico representado y agrupado por tipo de recetas
     */
    public void GraficoTipoRecetas(){
        XYChart.Series serieA = new XYChart.Series<>();
        XYChart.Series serieB = new XYChart.Series<>();
        XYChart.Series serieC = new XYChart.Series<>();
        XYChart.Series serieD = new XYChart.Series<>();
        
        serieA.getData().add(new XYChart.Data("Entrantes",numEntrantes));
        serieB.getData().add(new XYChart.Data("Primeros",numPrimeros));
        serieC.getData().add(new XYChart.Data("Segundos",numSegundos));
        serieD.getData().add(new XYChart.Data("Postres",numPostres));
        
        TipoRecetasBarChar.getData().addAll(serieA,serieB,serieC,serieD);
        
    }
        
    /**
     * Metodo onClick para ver la seccion de de estadistica en formato Barras
     * @param event 
     */
    @FXML
    private void BarrasClick(ActionEvent event) {
        panelBarras.setVisible(true);
        panelSector.setVisible(false);
        panelTipoReceta.setVisible(false);
    }
    

    /**
     * Metodo onClick para ver la seccion de de estadistica en formato Sector
     * @param event 
     */
    @FXML
    private void SectorClick(ActionEvent event) {
        panelBarras.setVisible(false);
        panelSector.setVisible(true);
        panelTipoReceta.setVisible(false);
        pieChart.setVisible(true);     
    }

    /**
     * Metodo onClick para ver la seccion de calorias
     * @param event 
     */
    @FXML
    private void CaloriasClick(ActionEvent event) {
        
        hboxTipoRecetas.setVisible(true);
        panelBarras.setVisible(true);
        panelTipoReceta.setVisible(false);
        pieChart.setVisible(false);
        labelInfo.setText("Calorias media: " + caloriasMedia);
        labelInfo.setVisible(true);
        Image imagen = new Image("recetasfx/icons/calorias.png");
        img.setImage(imagen);
    }

    /**
     * Metodo onClick para ver la seccion de tipos de recetas
     * @param event 
     */
    @FXML
    private void TipoRecetasClick(ActionEvent event) {
        hboxTipoRecetas.setVisible(false);
        labelInfo.setText("Total de recetas: " + numTotal);
        labelInfo.setVisible(true);
        panelTipoReceta.setVisible(true);
        panelBarras.setVisible(false);
        panelSector.setVisible(false);
        Image imagen = new Image("recetasfx/icons/noodles.png");
        img.setImage(imagen);
        
    }
    
    /**
     * Calcula la media de las calorias de todas las recetas existentes en nuestra ddbb
     */
    private void calcularCaloriasMedia(){
        int total=0;
        for (Receta receta : list) {
           total= total+receta.getCalorias(); 
        }
        caloriasMedia = total/list.size();
    }
}
