/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.entities;

/**
 *
 * @author Jose
 */
public class Usuario {
    
    String user, password, rol;

    /**
     * Constructor del usuario con todos los datos
     * @param user
     * @param password
     * @param rol 
     */
    public Usuario(String user, String password, String rol) {
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    //Constructor por defecto
    public Usuario() {
    }

    //Comienzo de getters y setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
