/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import static sun.text.normalizer.UTF16.append;

/**
 *
 * @author Jose
 */
public class FileManager {
    
    String ruta;
    File file = new File(ruta);
    //Constructor por defecto
    public FileManager(){}
    /**
     * Constructor en el que se le pasa la ruta del archivo
     */
    public FileManager(String ruta){		
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
            writer = new FileWriter(file);
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
     */		
    public void leerArchivo() throws IOException{
        FileReader reader = null;
        BufferedReader br = null;
        try{ 
            reader = new FileReader(file);	
            br = new BufferedReader(reader);
            String line;
            while((line = br.readLine()) != null)
        {
            System.out.println(line);
        }
        }catch(Exception e){
            System.out.println("Ha habido un error al leer el archivo");
        }finally{
            reader.close();
            br.close();
        }
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
