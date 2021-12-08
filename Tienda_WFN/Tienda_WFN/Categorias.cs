using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Controlador;
namespace Tienda_WFN
{
    public partial class Categorias : Form
    {
        Controlador.ControladorCategorias controlador = new Controlador.ControladorCategorias();
        public Categorias()
        {
            InitializeComponent();
            crearBotones();
        }

        /**
         *Metodo para crear los botones de las categorias,
         *utilizando las categorias que existen dentro de la base de datos
         *Los botones son dinamicos, por lo que tiene que leer la base de datos y se van añadiendo con una posición
         *según el número de botón que sea
         */ 
        private void crearBotones()
        {
            List<String> categorias = controlador.recogerCategorias();
            for(int i = 0; i < categorias.Count; i++)
            {
                Button btn = new Button();
                btn.Margin = new Padding(4, 3, 4, 3);
                btn.BackColor = Color.Black;
                btn.Location = new Point(30, 30 + i * 60);
                btn.Size = new Size(125, 54);
                btn.ForeColor = Color.White;
                btn.Text = categorias[i];
                this.Controls.Add(btn);
            }


        }
    }
}
