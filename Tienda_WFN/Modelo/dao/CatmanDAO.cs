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
    /**
     * Clase Category Man DAO en la que se usa para acceder a los datos
     * de la base de datos de la clase catman
     * Se usan los diferentes metodos para utilizar los datos
     */
    public class CatmanDAO
    {
        private static DBConnection dataSource;
        MySqlConnection connection = null;
        MySqlCommand mysqlCmd = null;
        MySqlDataReader mysqlReader = null;
        MySqlDataAdapter adapter = null;
        DataTable dataTable = null;

        public CatmanDAO()
        {
            dataSource = DBConnection.getInstance();
        }
        /**
         * Función que devuelve un DataTable con toda la información 
         * que está dentro de la tabla "catman"
         */
        public DataTable tablaGrid()
        {
            string sql = "SELECT * FROM " + CatmanEntry.TABLE + ";";
            try
            {
                connection = dataSource.getConnection(); // Establecer la conexión con la base de datos
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);
                dataTable = new DataTable();
                adapter = new MySqlDataAdapter(mysqlCmd);

                adapter.Fill(dataTable); // con el adaptador se rellena el datatable
                

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

        /**
        *Metodo que devuelve una lista de String con todas las categorias 
        *dentro de la tabla CatMan
        */
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

                //condicional que añade las categorias de CatMan en la lista @categorias
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

        public DataTable filtrarCategoria(string category)
        {
            string sql = "";

            switch (category)
            {
                case "Jeans":
                    sql = "SELECT * FROM " + CatmanEntry.TABLE + " WHERE " + CatmanEntry.CATEGORY + " LIKE 'Jeans'";
                    break;
                case "Shirt":
                    sql = "SELECT * FROM " + CatmanEntry.TABLE + " WHERE " + CatmanEntry.CATEGORY +" LIKE 'Shirts'";
                    break;
                case "T-Shirt":
                    sql = "SELECT * FROM " + CatmanEntry.TABLE + " WHERE " + CatmanEntry.CATEGORY + " LIKE 'T-shirts'";
                    break;
                case "All":
                    sql = "SELECT * FROM " + CatmanEntry.TABLE + ";";
                    break;
            }

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);
                dataTable = new DataTable();
                adapter = new MySqlDataAdapter(mysqlCmd);
                adapter.Fill(dataTable);

            }
            catch (Exception e)
            {
                Console.WriteLine("error " + e.ToString());
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (adapter != null) adapter.Dispose();
                if (connection != null) connection.Close();
            }
            return dataTable;
        }

        public int updateQuantity(String id, int newQuantity)
        {
            String sql = "UPDATE " + CatmanEntry.TABLE +
                " SET " + CatmanEntry.QUANTITY + " = " + newQuantity +
                " WHERE " + CatmanEntry.ID + " = " + id;
            int filas = 0;

            try
            {
                connection = dataSource.getConnection();
                connection.Open();
                mysqlCmd = new MySqlCommand(sql, connection);
                filas = mysqlCmd.ExecuteNonQuery();
                /*
                adapter = new MySqlDataAdapter(mysqlCmd);
                adapter.Fill(dataTable);*/
            }
            catch (Exception e)
            {
                Console.WriteLine("error " + e.ToString());
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (adapter != null) adapter.Dispose();
                if (connection != null) connection.Close();
            }

            return filas;
        }

    }
    
}
