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

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DialogResult resultado = MessageBox.Show("¿Seguro que quieres salir?", "Salir", MessageBoxButtons.YesNo);
            if(resultado == DialogResult.Yes)
            {
                Application.Exit();
            }
        }

        private void buscarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Buscar Paciente");
        }

        private void verFichaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Ver ficha Paciente");
        }

        private void sacarEtiquetaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Sacar Etiqueta Paciente");
        }

        private void actasClinicasToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Actas Clinicas Paciente");
        }

        private void buscarToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Buscar Nota");
        }

        private void crearToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Crear Nota");
        }

        private void modificarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Modificar Nota");
        }

        private void eliminarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Eliminar Nota");
        }
    }
}
