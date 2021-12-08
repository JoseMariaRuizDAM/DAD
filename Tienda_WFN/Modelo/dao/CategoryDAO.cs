using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace Modelo
{
    public class CategoryDAO
    {

        private static DBConnection dataSource;
        MySqlConnection connection = null;
        MySqlCommand mysqlCmd = null;
        MySqlDataReader mysqlReader = null;
        SqlDataAdapter adaptador = new SqlDataAdapter();
        public CategoryDAO()
        {
            dataSource = DBConnection.getInstance();
        }
        /**
         * Función que recoge de todas las categorias de la base de datos de la tabla categorias
         * se introducen en una lista.
         */
        public List<String> findAll()
        {
            
            //Unable to connect database.
            List<string> nombres = null;
            string sql = "SELECT * FROM " + CategoryEntry.TABLE; //sentencia SQL para recoger toda la información de la tabla categoria
            try
            {
                connection = dataSource.getConnection(); //Establecer la cadena de conexión.
                connection.Open(); //Open connection.

                mysqlCmd = new MySqlCommand(sql, connection);
                mysqlReader = mysqlCmd.ExecuteReader(); //Executes query and get result.

                while (mysqlReader.Read())
                { 
                    String nombre = mysqlReader[CategoryEntry.DESCRIPCION].ToString();
                    nombres.Add(nombre);
                }

            }
            catch(Exception ex) 
            {
                MessageBox.Show("Error");
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mysqlReader != null) mysqlReader.Dispose();
                if (connection != null) connection.Close();
            }
            return nombres;
        }

        
    }
}
