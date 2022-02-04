/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.DAO;

import recetasfx.modelo.entities.Receta;
import recetasfx.modelo.utils.FileManagers.FileManagerUsuarios;

/**
 *
 * @author Jose
 */
public class RecetaDao {
    
    Receta receta = new Receta();
    FileManagerUsuarios fileManager = new FileManagerUsuarios("recetas.txt");
    
    //Constructor por defecto
    public RecetaDao(){}
    
    /**
    * Metodo para la creación de un receta en el archivo recetas.txt
    */
    public boolean crearUsuario(String nombre,
                                String autor,
                                String tipo,
                                String ingrediente,
                                String pasos,
                                int comensales,
                                int minutos,
                                int calorias){
			
        boolean creado = false;
			
        try //Comienzo a escribir la receta en el archivo		
        {
            this.receta.setNombre(nombre);
            this.receta.setAutor(autor);
            this.receta.setTipoReceta(tipo);
            this.receta.setPasos(pasos);
            this.receta.setComensales(comensales);
            this.receta.setTiempoPreparacion(minutos);
            this.receta.setCalorias(calorias);
            creado = fileManager.escribirConSaltoLinea(receta.toString());
            
	/*			
            if(!fileManager.findByString(User.)){ //Comprueba que el DNI introducido no esta en el archivo 
				
					creado = fileManager.escribirConSaltoLinea(patient.toString());
				}
				else
				{
					MessageBox.Show("El DNI que has introducido, ya esta en la base de datos");
				}*/
			
        }catch (Exception e){
            System.out.println("No se ha podido crear el paciente");			
        }
        
        return creado;		
    }
}
