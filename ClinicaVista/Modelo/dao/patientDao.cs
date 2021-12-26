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
			patient = new Patient(dni, nombre, apellidos, direccion, poblacion, nhc);
			try{
				StreamWriter sw = new StreamWriter("patients.txt");
				sw.WriteLine(patient.Dni + ";" + patient.Nombre + ";" + patient.Apellidos + ";" + patient.Direccion + ";" + patient.Poblacion + ";" + patient.NHC1);

			}catch(Exception e){
				MessageBox.Show("No se ha podido crear el paciente");
			}
		}
	}
}
