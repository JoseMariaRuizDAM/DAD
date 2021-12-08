using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace Modelo
{

    public class CatmanDAO
    {
        private static DBConnection dataSource;
        MySqlConnection connection = null;
        MySqlCommand mysqlCmd = null;
        MySqlDataReader mysqlReader = null;
        MySqlDataAdapter adapter = null;
        DataTable dataTable = null;

        /**
         * Función que devuelve un DataTable con toda la información que está dentro de la tabla "catman"
         */

        public DataTable tablaGrid()
        {
            string sql = "SELECT * FROM " + CatmanEntry.TABLE;
            try
            {
                connection = dataSource.getConnection(); // Establecer la conexión con la base de datos
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);
                dataTable = new DataTable();
                adapter = new MySqlDataAdapter(mysqlCmd);

                adapter.Fill(dataTable);
                

            }catch(Exception e) {
                MessageBox.Show("Ha habido un error");
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (connection != null) connection.Close();
            }

            return dataTable;
        }

        public List<String> listAllCategories()
        {
            String sql = "SELECT " + CatmanEntry.CATEGORY + " FROM " + CategoryEntry.TABLE;
            List<string> categorias = new List<string>();

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                mysqlReader = mysqlCmd.ExecuteReader();

                while (mysqlReader.Read())
                {
                    string categoria = mysqlReader[CatmanEntry.CATEGORY].ToString();

                    categorias.Add(categoria);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("ERROR!: " + ex.ToString());
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mysqlReader != null) mysqlReader.Dispose();
                if (connection != null) connection.Close();
            }

            return categorias;
        }        
    }
}
