/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.utils.FileManagers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import recetasfx.modelo.entities.Receta;
import recetasfx.modelo.entities.Usuario;
//import static sun.text.normalizer.UTF16.append;

/**
 *
 * @author Jose
 */
public class FileManagerUsuarios {
    
    String ruta;
    ArrayList<Usuario>users = new ArrayList<>();
    //ArrayList<Receta>recipes = new ArrayList<>();
    File archivoUsuario = new File("users.txt");
    //File archivoRecetas = new File("recetas.txt");
    
    //Constructor por defecto
    public FileManagerUsuarios(){}
    
    /**
     * Constructor en el que se le pasa la ruta del archivo
     */
    public FileManagerUsuarios(String ruta){		
        this.ruta = ruta;	
    }
    
    /**
    * Metodo para escribir en un archivo
    * se le pasa un String con el valor de lo que se quiera escribir
    * dentro del mismo archivo con saltos de linea cada vez que se usa
    */
    public boolean escribirConSaltoLinea(String valor){
	
        FileWriter writer = null;
        try{
            writer = new FileWriter(archivoUsuario);
            PrintWriter pw = new PrintWriter(writer);
            pw.println(valor);
	    pw.flush();	
            pw.close();
            writer.close();
            return true;		
        }catch(Exception e)
        {
            System.out.println("Ha habido un error al crear el paciente");
            return false;
        }
    }
    
    /**
     * Metodo para leer un archivo completo
     * devolviendo este archivo en un ArrayList
     */		
    public ArrayList<Usuario> loginUsuarios() throws IOException{
        Path pathFile = archivoUsuario.toPath();

            if (pathFile != null) {
                try (BufferedReader bf = Files.newBufferedReader(pathFile)){
                String texto;
                
                while ((texto = bf.readLine())!=null){
                    String[]datos = texto.split(":");
                    Usuario user = new Usuario(datos[0], datos[1], datos[2]);
                    users.add(user);
                    }
                bf.close();
                }
            }
        
        return users;
        
    }
    
    public int contarLineas()throws IOException{
        FileReader reader = null;
        BufferedReader br = null;
        int cont = 0;
        try{ 
            reader = new FileReader(archivoUsuario);	
            br = new BufferedReader(reader);
            String line;
            while((line = br.readLine()) != null) {
                cont++;
            }
        }catch(Exception e){
            System.out.println("Ha habido un error al leer el archivo");
        }finally{
            reader.close();
            br.close();
        }
        return cont;
    }


    public void findByString(String palabra){
			
        /*
        boolean bandera = false;
		
        StreamReader reader = new StreamReader(file);
	
        String line;
	
        while ((line = reader.ReadLine()) != null)
	
        {
	
            if(line.Contains(palabra)){                        
                bandera = true;		
            }
			
        }
	
        reader.Close();
	
        return bandera;
*/
    }
}
