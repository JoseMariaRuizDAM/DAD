/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import recetasfx.modelo.entities.Usuario;
import recetasfx.modelo.utils.FileManagers.FileManagerUsuarios;

/**
 *
 * @author Jose
 */
public class UsuarioDao {
    
    Usuario user = new Usuario();
    FileManagerUsuarios fileManager = new FileManagerUsuarios("users.txt");
    int numUsuarios = 0;
    
    /**
     * Construtor por defecto 
     * en el que se añade la cantidad de usuarios
     * que hay dentro del archivo
     */
    public UsuarioDao() throws IOException{
        numUsuarios = fileManager.contarLineas();
    }
    
    /**
    * Metodo para la creación de un usuario en el archivo users.txt
    */
    public boolean crearUsuario(String nombre,
                                String password,
                                String rol){
			
        boolean creado = false;
			
        try //Comienzo a escribir el usuario en el archivo		
        {
            this.user.setUser(nombre);
            this.user.setPassword(password);
            this.user.setRol(rol);
            creado = fileManager.escribirConSaltoLinea(user.toString());			
        }catch (Exception e){
            System.out.println("No se ha podido crear el paciente");			
        }
        
        return creado;		
    }
    /*
    public String UserLogin(Usuario user) throws IOException {
        user = new Usuario(user.getUser(), user.getPassword());
        String rol = null;
        ArrayList<Usuario> usuarios = fileManager.loginUsuarios();
        String[] nombre = new String[numUsuarios];
        String[] contra = new String[numUsuarios];
        String[] puesto = new String[numUsuarios];
        int cont = 0;
        try{
            for (String linea : usuarios) {
                String[] partes = linea.split(";"); //se divide cada linea con un split
                nombre[cont] = partes[0]; // nombre del nombre en el archivo
                contra[cont] = partes[1]; // contraseña del nombre en el archivo
                puesto[cont] = partes[2]; // rol del nombre en el archivo
                String recogerNombre = nombre[cont];
                String recogerContra = contra[cont];            
                //Se comprueba si es igual el nombre que se le ha pasado a los datos que estan dentro del archivo
                if (recogerNombre.equals(user.getUser()) && recogerContra.equals(user.getPassword())){
                    rol = puesto[cont];
                }
                else if(rol == null)
                {
                    rol = null;
                }
                cont++; // se usa el contador para saber que nombre es y se suma uno a cada vuelta del foreach
            }       
        }catch(Exception e){
            String error = e.getMessage();
            System.out.println("Ha habido un error: " + error);
            rol = null;
        }
        return rol;
    }*/
}    

