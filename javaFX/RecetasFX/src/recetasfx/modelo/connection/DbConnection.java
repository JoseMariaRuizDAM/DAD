/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class DbConnection {
    
    private static Connection connection;
    private final static String driver="com.mysql.jdbc.Driver";
    private final static String user="root";
    private final static String password="";
    private final static String url="jdbc:mysql://localhost/recetas";
    
    public DbConnection(){
        connection = null;
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
            if(connection!=null){
                System.out.println ("Conexión establecida...");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en "+e);
            System.exit(1);
        }
    }

    public Connection getConnection(){
        //if(connection == null) 
            
           return connection;
       }

    public void close(){
       try {
           connection.close();
       } catch (SQLException ex) {
           Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
