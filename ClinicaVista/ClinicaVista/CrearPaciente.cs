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
	public partial class CrearPaciente : Form
	{
		public CrearPaciente()
		{
			InitializeComponent();
		}

		/**
		 * Función que se ejecuta cuando se presiona el botón crear en la ventana de dialogo
		 * Recogera los datos que se han añadido en todos los campos
		 * en caso de que todos los campos no esten rellenos, no los recogera
		 * si el DNI, no es correcto no los recogera y avisara al usuario
		 * el NHC debe de ser entero y no estar en el archivo.
		 * Si todo esta correcto guarda los datos en un archivo de pacientes.
		 */
		private void crear_btn_crear_Click(object sender, EventArgs e)
		{
			//Comprobación de que todos los campos contengan información
			if(dni_crear.Text != null &&
				nombre_crear.Text != null &&
				apellidos_crear.Text != null &&
				direccion_crear.Text != null &&
				poblacion_crear.Text != null &&
				nhc_crear.Text != null)
			{
				//Comprobación de que el DNI esta correcto
				if (dni_crear.TextLength == 9)
				{
					bool correcto = new Controlador.ControladorClase().comprobarDNI(dni_crear.Text);
					
					if(correcto == true) // si el dni esta correcto, se continuara con la creación del paciente.
					{
						String dni = dni_crear.Text;
						String nombre = nombre_crear.Text;
						String apellidos = apellidos_crear.Text;
						String direccion = direccion_crear.Text;
						String poblacion = poblacion_crear.Text;
						String nhc = nhc_crear.Text;


					}
				}
				else
				{
					MessageBox.Show("El DNI es incorrecto: Longitud incorrecta");
				}
			}

			else
			{
				MessageBox.Show("Tienes que rellenar todos los campos", "Alerta");
			}
			

			

		}
	}
}
