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
        AddItem addItem;
        /**
         * Cuando se carga el formulario se añade la lista del datagridview
         */
        public Man_Category()
        {
            InitializeComponent();
            Man_Category_Load();
        }
        
        public void Man_Category_Load()
        {
            dataGridView1.DataSource = controlador.tablaCatman(); // metodo de llamada para recoger los datos de la base de datos al datagridview
            dataGridView1.Update(); // con este metodo estoy añadiendo la lista en el listBox.
        }

        /**
         * Metodo filtra la lista del datagrid según selecciona en listbox el usuario
         * y aprieta en el boton.
         */
        private void filter_btn_Click(object sender, EventArgs e)
        {
            int intselectedindex = listView1.SelectedIndices[0];

           if(intselectedindex < 0)
            {
                MessageBox.Show("No has seleccionado ninguna categoria");
            }
            if (intselectedindex >= 0)
            {
                String categoria = listView1.Items[intselectedindex].Text;
                dataGridView1.DataSource = controlador.FiltrarCategoria(categoria);
            }
        }

        private void Add_btn_Click(object sender, EventArgs e)
        {
            int index = dataGridView1.CurrentRow.Index;

            if (index >= 0)
            {
                string id = dataGridView1.Rows[index].Cells[0].Value.ToString();
                string name = dataGridView1.Rows[index].Cells[1].Value.ToString();
                string quantity = dataGridView1.Rows[index].Cells[5].Value.ToString();
                new AddItem(id, name,quantity).Visible = true;
            }
            else
            {
                MessageBox.Show("No se ha seleccionado una fila", "Aviso");
            }
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void view_btn_Click(object sender, EventArgs e)
        {
            int index = dataGridView1.CurrentRow.Index;

            if (index >= 0)
            {
                string id = dataGridView1.Rows[index].Cells[0].Value.ToString();
                string name = dataGridView1.Rows[index].Cells[1].Value.ToString();
                string category = dataGridView1.Rows[index].Cells[2].Value.ToString();
                string quantity = dataGridView1.Rows[index].Cells[5].Value.ToString();
                MessageBox.Show("ID: " + id + "\nName: " + name + "\nCategory: " + category + "\nQuantity: " + quantity);
            }
            else
            {
                MessageBox.Show("No se ha seleccionado una fila", "Aviso");
            }
        }
    }
}
