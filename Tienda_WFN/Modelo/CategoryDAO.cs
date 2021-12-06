using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace Modelo
{
    public class CategoryDAO
    {

        private static DBConnection dataSource;

        public CategoryDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        public List<String> findAll()
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;

            //Unable to connect database.
            List<string> nombres = null;

            string sql = "SELECT * FROM " + CategoryEntry.TABLE;
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
            catch(Exception ex) { }
            return nombres;
        }
    }
}
