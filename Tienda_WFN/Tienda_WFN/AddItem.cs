using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Tienda_WFN
{
    public partial class AddItem : Form
    {

        Man_Category man_Category;
        private String id;
        private String name;
        private String quantity;

        /**
         * Constructor en el que se le pasa el @id del producto
         * y @quantity (cantidad) del producto seleccionado
         * en el formulario @Man_Category.cs
         * Muestra la información del producto, su ID como la cantidad
         * que hay en stock
         */
        public AddItem(String id, String name, String quantity)
        {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            InitializeComponent();
            id_label.Text = id;
            name_label.Text = name;
            informacion_label.Text = "Hay " + quantity + " en stock"
                                      + "\nde " + name;
        }

        private void AddItem_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void id_label_Click(object sender, EventArgs e)
        {

        }
        /**
         * Función que se activa cuando se hace click en el botón "add basquet"
         * Recoge la @cantidad (@quantity_add_box) que añade el cliente 
         * La cantidad debera de ser mayor que el stock que hay en la base de datos
         */
        private void add_basquet_btn_Click(object sender, EventArgs e)
        {
            int cantidad = int.Parse(quantity_add_box.Text);
            Controlador.ControladorCatman controladorCatman = new Controlador.ControladorCatman();
            int restoStock = int.Parse(this.quantity) - cantidad;
            if (restoStock > 0) // en caso de que la cantidad que añade el usuario es mayor que 0 se actualiza la base de datos
            {
                DataTable tabla = controladorCatman.addBasquet(this.id, restoStock);   
            }
            else
            {
                MessageBox.Show("No hay suficiente stock de " + this.name);
            }
            this.Close();
            man_Category = new Man_Category();
            man_Category.Show();
        }
    }
}
