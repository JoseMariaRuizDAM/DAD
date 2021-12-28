using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Modelo.Utilities;

namespace Modelo.dao
{
	//Dao de pacientes
	public class patientDao
	{
		Patient patient = new Patient();
		FileManager fileManager = new FileManager("patients.txt");
		//Constructor sin datos por default
		public patientDao()
		{
		}

		/**
		 * Metodo para la creación de un paciente en el archivo patients.txt
		 */
		public bool crearPaciente(String dni, 
			String nombre, 
			String apellidos, 
			String direccion, 
			String poblacion, 
			String nhc)
		{
			bool creado = false;

			try //Comienzo a escribir el paciente en el archivo
			{
				patient.Dni = dni;
				patient.Nombre = nombre;
				patient.Apellidos = apellidos;
				patient.Direccion = direccion;
				patient.Poblacion = poblacion;
				patient.NHC1 = nhc;
				
				if(!fileManager.findByString(patient.Dni)) //Comprueba que el DNI introducido no esta en el archivo 
				{
					creado = fileManager.escribirConSaltoLinea(patient.toString());
				}
				else
				{
					MessageBox.Show("El DNI que has introducido, ya esta en la base de datos");
				}
			}
			catch (Exception e){
				MessageBox.Show("No se ha podido crear el paciente");
			}
			return creado;
		}
	}
}
