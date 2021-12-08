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
using Controlador;

namespace Tienda_WFN
{
    public partial class Man_Category : Form
    {
        Controlador.ControladorCatman controlador = new Controlador.ControladorCatman();
        AddItem addItem = new AddItem();
        /**
         * Cuando se carga el formulario se añade la lista del datagridview
         */
        public Man_Category()
        {
            InitializeComponent();
            
        }
        
        public void Man_Category_Load(object sender, EventArgs e)
        {
            controlador.tablaCatman(); // metodo de llamada para recoger los datos de la base de datos al datagridview
            listBox1.DataSource = controlador.listaCategorias(); // con este metodo estoy añadiendo la lista en el listBox.
        }

        /**
         * Metodo filtra la lista del datagrid según selecciona en listbox el usuario
         * y aprieta en el boton.
         */
        private void filter_btn_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedItem != null)
            {
                string selectCategoria = listBox1.SelectedItem.ToString();
                dataGridView1.DataSource = dataGridView1.Columns.Contains(selectCategoria);
            }
            else
            {
                MessageBox.Show("No has seleccionado ninguna categoria");
            }
            
        }

        private void Add_btn_Click(object sender, EventArgs e)
        {
            addItem.Show();
        }
    }
}
