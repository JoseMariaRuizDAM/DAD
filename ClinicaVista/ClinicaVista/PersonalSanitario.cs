using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClinicaVista
{
    public partial class PersonalSanitario : Form
    {
        public PersonalSanitario()
        {
            InitializeComponent();
        }

        private void PersonalSanitario_Load(object sender, EventArgs e)
        {

        }

        private void toolStripMenuItem1_Click(object sender, EventArgs e)
        {

        }

        /**
         * Función que funciona cuando se selecciona el botón salir
         * Cuando se presiona, una ventana de dialogo que prgunta al usuario
         * si quiere salir o no de la ventana 
         */
        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DialogResult resultado = MessageBox.Show("¿Seguro que quieres salir?", "Salir", MessageBoxButtons.YesNo);
            if(resultado == DialogResult.Yes)
            {
                Application.Exit();
            }
        }

        //Muestra una ventana de dialogo cuando se presiona el boton Buscar Paciente
        private void buscarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Buscar Paciente");
        }

        //Muestra una ventana de dialogo cuando se presiona el botón "Ver ficha paciente"
        private void verFichaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Ver ficha Paciente");
        }

        //Muestra una ventana de dialogo cuando se presiona el botón "Sacar Etiqueta Paciente"
        private void sacarEtiquetaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Sacar Etiqueta Paciente");
        }

        //Muestra una ventana de dialogo cuando se presiona el botón "Actas Clinicas Paciente"
        private void actasClinicasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Actas Clinicas Paciente");
        }

        //Muestra una ventana de dialogo cuando se presiona el botón "Buscar Nota"
        private void buscarToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Buscar Nota");
        }

        //Muestra una ventana de dialogo cuando se presiona el botón "Crear Nota"
        private void crearToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Crear Nota");
        }

        //Muestra una ventana de dialogo cuando se presiona el botón "Modificar Nota"
        private void modificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Modificar Nota");
        }

        //Muestra una ventana de dialogo cuando se presiona el botón "Eliminar Nota"
        private void eliminarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Eliminar Nota");
        }
    }
}
