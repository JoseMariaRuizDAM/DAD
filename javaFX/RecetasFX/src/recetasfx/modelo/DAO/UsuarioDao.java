/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import recetasfx.modelo.connection.DbConnection;
import recetasfx.modelo.entities.Usuario;
import recetasfx.modelo.contract.UsuarioEntry;

/**
 *
 * @author Jose
 */
public class UsuarioDao extends UsuarioEntry implements ICRUD<Usuario, String>{
    
    
    DbConnection db;
    Usuario user = new Usuario();
    int numUsuarios = 0;
    
    /**
     * Construtor por defecto 
     * en el que se añade la cantidad de usuarios
     * que hay dentro del archivo
     */
    public UsuarioDao(DbConnection db){
        this.db = db;
    }
    
    @Override
    public Usuario select(String id) {
        try (Connection connection = db.getConnection()) {
            String sql = "SELECT * FROM " + TABLE_NAME + " where " + USER + " = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                    return new Usuario(rs.getString(USER), rs.getString(PASSWORD), rs.getString(ROLE));
            return null;
        } catch (SQLException e) {
                return null;
        }
    }

    @Override
    public List<Usuario> selectAll() {
        
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try (Connection connection = db.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM " + TABLE_NAME;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) 
                usuarios.add(new Usuario(rs.getString(USER),rs.getString(PASSWORD),rs.getString(ROLE)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return usuarios;
        }
    }

    @Override
    public Usuario insert(Usuario usuario) throws SQLException {
        try (Connection connection = db.getConnection()) {
                String sql = "INSERT INTO " + TABLE_NAME + " (" + USER + ", " + PASSWORD + ", " + ROLE  + ") VALUES (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, usuario.getUser());
                ps.setString(2, usuario.getPassword());
                ps.setString(3, usuario.getRol());
                int affectedRows = ps.executeUpdate();
                if (affectedRows <= 0) {
                        throw new SQLException("Error. No se pudo crear el usuario. Ninguna fila afectada.");
                }
        } catch (SQLException e) {
                throw new SQLException(e.getMessage());
        } finally {
                return usuario;
        }
    }

    @Override
    public boolean update(Usuario usuario) throws SQLException {
        try (Connection connection = db.getConnection()) {
            String sql = "UPDATE users SET password = ?, role = ? WHERE nick = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getPassword());
            ps.setString(2, usuario.getRol());
            ps.setString(3, usuario.getUser());
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                return true;
            } else {
                throw new SQLException("Error. No se pudo actualizar el usuario. Ninguna fila afectada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String user) throws SQLException {
        try (Connection connection = db.getConnection()) {
                String sql = "DELETE  FROM " + TABLE_NAME + " WHERE " + USER + " = ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, user);
                int affectedRows = ps.executeUpdate();
                if (affectedRows > 0) {
                        return true;
                } else {
                        throw new SQLException("Error. No se pudo borrar el usuario. Ninguna fila afectada.");
                }
        } catch (SQLException e) {
                e.printStackTrace();
                return false;
        }    
    }
}    

