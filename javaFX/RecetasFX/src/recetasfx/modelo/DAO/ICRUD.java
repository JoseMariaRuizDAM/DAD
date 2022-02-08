/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recetasfx.modelo.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jose
 */
public interface ICRUD<T,E> {
    
    T select(E id);
    List<T> selectAll();
    T insert(T entity) throws SQLException;
    boolean update(T entity) throws SQLException;
    boolean delete(E id) throws SQLException;

}
