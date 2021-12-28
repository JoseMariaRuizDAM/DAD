using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Modelo.dao
{
	//Dao de pacientes
	public class patientDao
	{
		String archivo = "patients.txt";
		Patient patient;
		//Constructor sin datos por default
		public patientDao()
		{
		}

		/**
		 * Metodo para la creación de un paciente en el archivo patients.txt
		 */
		public void crearPaciente(String dni, String nombre, String apellidos, String direccion, String poblacion, String nhc)
		{
			patient = new Patient();
			//Comienzo a escribir el paciente en el archivo
			try
			{
				FileStream pacientesArch = new FileStream(archivo, FileMode.Append, FileAccess.ReadWrite);
				StreamWriter sw = new StreamWriter(pacientesArch);
				sw.WriteLine(dni + ";" + nombre + ";" + apellidos + ";" + direccion + ";" + poblacion + ";" + nhc);
				sw.Close();
				pacientesArch.Close();
			}
			catch(Exception e){
				MessageBox.Show("No se ha podido crear el paciente");
			}
		}
	}
}
