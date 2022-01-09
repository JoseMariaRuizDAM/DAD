/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.DAO;

import recetasfx.modelo.entities.Usuario;
import recetasfx.modelo.utils.FileManager;

/**
 *
 * @author Jose
 */
public class UsuarioDao {
    
    Usuario user = new Usuario();
    FileManager fileManager = new FileManager("users.txt");
    
    //Construtor por defecto
    public UsuarioDao(){}
    
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
