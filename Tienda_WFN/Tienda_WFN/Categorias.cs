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
        Controlador.Controlador c = new Controlador.Controlador();
        public Categorias()
        {
            InitializeComponent();
            crearBotones();
        }

        private void crearBotones()
        {
            List<String> categorias = c.recogerCategorias();
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
