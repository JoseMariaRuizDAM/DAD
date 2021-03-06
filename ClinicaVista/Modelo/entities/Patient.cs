using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
	public class Patient
	{
		String dni;
		String nombre;
		String apellidos;
		String direccion;
		String poblacion;
		String NHC;

		//Constructor por defecto
		public Patient()
		{
		}
		//Constructor para crear paciente con los datos que se le pasan 
		public Patient(String DNI,
			String nombre,
			String apelidos,
			String direccion,
			String poblacion,
			String NHC)
		{
		}

		/*
		 * Metodo creado para generar una linea de texto
		 * con todos los datos del paciente y que se devuelva
		 */
		public String toString()
		{
			return this.dni + ";" + 
				this.nombre + ";" +
				this.apellidos + ";" +
				this.direccion + ";" +
				this.poblacion + ";" +
				this.NHC + ";"; 
		}
		//Getters and setters
		public string Nombre { get => nombre; set => nombre = value; }
		public string Apellidos { get => apellidos; set => apellidos = value; }
		public string Direccion { get => direccion; set => direccion = value; }
		public string Poblacion { get => poblacion; set => poblacion = value; }
		public string NHC1 { get => NHC; set => NHC = value; }
		public string Dni { get => dni; set => dni = value; }
	}
}
