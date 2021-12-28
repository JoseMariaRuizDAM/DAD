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
		//String archivo = "patients.txt";
		Patient patient = new Patient();
		FileManager fileManager = new FileManager("patients.txt");
		//Constructor sin datos por default
		public patientDao()
		{
		}

		/**
		 * Metodo para la creación de un paciente en el archivo patients.txt
		 */
		public bool crearPaciente(String dni, String nombre, String apellidos, String direccion, String poblacion, String nhc)
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

				fileManager.escribirConSaltoLinea(patient.toString());
				
				/*
				StreamWriter sw = new StreamWriter(archivo, append: true);
				sw.WriteLine(patient.toString());
				sw.Flush();
				sw.Close();
				*/
				creado = true;
			}
			catch(Exception e){
				MessageBox.Show("No se ha podido crear el paciente");
			}
			return creado;
		}
	}
}
