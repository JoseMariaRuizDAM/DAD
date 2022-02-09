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
import recetasfx.modelo.contract.RecetaEntry;
import recetasfx.modelo.entities.Receta;


/**
 *
 * @author Jose
 */
public class RecetaDao extends RecetaEntry implements ICRUD<Receta, String> {
    
    DbConnection db;
    public RecetaDao(DbConnection db) {
        this.db = db;
    }
    
    @Override
    public Receta select(String id) {
        try (Connection connection = db.getConnection()) {
            String sql = "SELECT * FROM " + TABLE_NAME + " where " + TITULO  + " = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return new Receta(rs.getString(TITULO),rs.getString(AUTOR),rs.getString(TIPO),
                            rs.getString(INGREDIENTES),rs.getString(IMAGEN),rs.getInt(PASOS),rs.getInt(NUMERO_COMENSALES),
                            rs.getInt(TIEMPO),rs.getInt(CALORIAS));
            }

            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<Receta> selectAll() {
        List<Receta> receta = new ArrayList<Receta>();
        try (Connection connection = db.getConnection()) {
                Statement stmt = connection.createStatement();
                String sql = "SELECT * FROM " + TABLE_NAME;
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    receta.add(new Receta(rs.getString(TITULO),rs.getString(AUTOR),rs.getString(TIPO),
                                rs.getString(INGREDIENTES),rs.getString(IMAGEN),rs.getInt(PASOS),rs.getInt(NUMERO_COMENSALES),
                                rs.getInt(TIEMPO),rs.getInt(CALORIAS)));
                }
                        
        } catch (SQLException e) {
                e.printStackTrace();
        } finally {
                return receta;
        }
    }

    @Override
    public Receta insert(Receta receta) throws SQLException {
        try (Connection connection = db.getConnection()) {
            String sql = "INSERT INTO " + TABLE_NAME 
                    + " (" + TITULO + ", " 
                    + AUTOR + ", " + TIPO 
                    + ", " + INGREDIENTES 
                    + ", " + PASOS + ", " 
                    + NUMERO_COMENSALES + ", " 
                    + TIEMPO + ", " + CALORIAS 
                    + ", " + IMAGEN + ") VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, receta.getNombre());
            ps.setString(2, receta.getAutor());
            ps.setString(3, receta.getTipoReceta());
            ps.setString(4, receta.getIngredientes());
            ps.setInt(5, receta.getPasos());
            ps.setInt(6, receta.getComensales());
            ps.setInt(7, receta.getTiempoPreparacion());
            ps.setInt(8, receta.getCalorias());
            ps.setString(9, receta.getImagen());
            int affectedRows = ps.executeUpdate();
            if (affectedRows <= 0) {
                    throw new SQLException("Error. No se pudo crear la receta. Ninguna fila afectada.");
            }
        } catch (SQLException e) {
                throw new SQLException(e.getMessage());
        } finally {
                return receta;
        }
    }

    @Override
    public boolean update(Receta receta) throws SQLException {
       
        try (Connection connection = db.getConnection()) {
            String sql = "UPDATE " + TABLE_NAME +" SET  Autor = ?, Tipo = ?, Ingrediente = ?, Pasos = ? , NumeroComensales = ? , Tiempo = ?, Calorias = ?, Imagen = ? WHERE Titulo = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, receta.getAutor());
            ps.setString(2, receta.getTipoReceta());
            ps.setString(3, receta.getIngredientes());
            ps.setInt(4, receta.getPasos());
            ps.setInt(5, receta.getComensales());
            ps.setInt(6, receta.getTiempoPreparacion());
            ps.setInt(7, receta.getCalorias());
            ps.setString(8, receta.getImagen());
            ps.setString(9, receta.getNombre());
            

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                return true;
            } else {
                throw new SQLException("Error. No se pudo actualizar la receta. Ninguna fila afectada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    @Override
    public boolean delete(String nombre) throws SQLException {
        try (Connection connection = db.getConnection()) {
            String sql = "DELETE  FROM " + TABLE_NAME + " WHERE " + TITULO + " = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nombre);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                return true;
            } else {
                throw new SQLException("Error. No se pudo borrar la receta. Ninguna fila afectada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }    
    }
    
    public List<Receta> selectByTipo(String tipoReceta) {
        List<Receta> receta = new ArrayList<Receta>();
        try (Connection connection = db.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM " + TABLE_NAME +" WHERE "+ TIPO +" = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tipoReceta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    receta.add(new Receta(rs.getString(TITULO),rs.getString(AUTOR),rs.getString(TIPO),
                            rs.getString(INGREDIENTES),rs.getString(IMAGEN),rs.getInt(PASOS),rs.getInt(NUMERO_COMENSALES),
                            rs.getInt(TIEMPO),rs.getInt(CALORIAS)));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return receta;
        }
    }
}
