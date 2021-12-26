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
    public partial class AdministrativoPantalla : Form
    {

        CrearPaciente crear = new CrearPaciente();
        public AdministrativoPantalla()
        {
            InitializeComponent();
        }

        private void menuStrip2_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void toolStripMenuItem1_Click(object sender, EventArgs e)
        {
            DialogResult resultado = MessageBox.Show("¿Seguro que quieres salir?", "Salir", MessageBoxButtons.YesNo);
            if (resultado == DialogResult.Yes)
            {
                Application.Exit();
            }
        }

        private void centroDeDíaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("«En construcción»");
        }

        private void citaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("«En construcción»");
        }

        private void guardarActividadToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("«En construcción»");
        }

        private void pacientesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            menuPacientesAdmin.Visible = true;
        }

        /*
         * Función que cuando se presiona sobre el botón agregar paciente
         * hara que se abra el nuevo formulario para agregar un nuevo paciente
         */
		private void toolStripButton2_Click(object sender, EventArgs e)
		{
            crear.Show(); //abre una nueva ventana de dialogo con CrearPaciente
		}
	}
}
