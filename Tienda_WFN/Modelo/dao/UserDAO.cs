using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace Modelo
{
    /**
     * Clase User DAO en la que se usa para acceder a los datos
     * de la base de datos para los usuarios o la clase User
     * Se usan los diferentes metodos para utilizar los datos
     */
    public class UserDAO
    {
        private static DBConnection dataSource;

        /**
         * Constructor de la clase en la que se hace 
         * la conexión a la base de datos
         */
        public UserDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        /**
         * Metodo que devuelve un boolean
         * Recoge el id y el password del usuario
         * Con estos datos comprueba que el usuario es el correcto
         * y que la contraseña es la correcta
         */
        public bool checkUser(long id, String pass)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;

            //Unable to connect database.
            bool validar = false;

            //sentencia SQL para recoger los datos del usuario
            string sql = "SELECT * FROM " + UserEntry.TABLE + " where " + 
                UserEntry.ID + "= @name and " + UserEntry.CONTRASENA + "= @contra";
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

                if (mysqlReader.Read()) //condición que lee los datos de la base de datos
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
