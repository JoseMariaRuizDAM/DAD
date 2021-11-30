using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
    public class UserDAO
    {
        private static DBConnection dataSource;

        public UserDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        public bool checkUser(long id, String pass)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;

            //Unable to connect database.
            bool validar = false;

            string sql = "SELECT * FROM users where id_staff= @name and password= @contra";
            try
            {
                connection = dataSource.getConnection(); //Establecer la cadena de conexión.
                connection.Open(); //Open connection.

                using (mysqlCmd = new MySqlCommand(sql, connection))
                {
                    mysqlCmd.Parameters.AddWithValue("@name", id);
                    mysqlCmd.Parameters.AddWithValue("@contra", pass);
                }
                mysqlReader = mysqlCmd.ExecuteReader(); //Executes query and get result.

                if (mysqlReader.Read())
                {
                    validar = true;
                }

            }
            catch (Exception e)
            {

            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mysqlReader != null) mysqlReader.Dispose();
                if (connection != null) connection.Close();
            }
            return validar;
        }
    }
}
