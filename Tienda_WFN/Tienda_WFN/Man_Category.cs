using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Modelo;

namespace Tienda_WFN
{
    public partial class Man_Category : Form
    {
        DataSet ds = new DataSet();
        CategoryDAO categoriaDao = new CategoryDAO();
        public Man_Category()
        {
            InitializeComponent();
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            string connectionString = "Persist Security Info = False; Integrated Security = SSPI; database = shop; server = (local)";
            string sql = "SELECT title_id,title,type,pub_id FROM Titles";
            SqlConnection connection = new SqlConnection(connectionString);
            SqlDataAdapter dataadapter = new SqlDataAdapter(sql, connection);
            connection.Open();
            dataadapter.Fill(ds, CategoryEntry.TABLE);
            connection.Close();

            dataGridView1.DataSource = ds.Tables[0];


        }
        
    }
}
