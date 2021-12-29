using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Modelo.Utilities
{
	public class FileManager
	{
		String file;
		
		//Constructor por defecto
		public FileManager()
		{
		}

		/**
		 * Constructor en el que se le pasa la ruta del archivo
		 */
		public FileManager(String file)
		{
			this.file = file;
		}
		/**
		 * Metodo para escribir en un archivo
		 * se le pasa un String con el valor de lo que se quiera escribir
		 * dentro del mismo archivo con saltos de linea cada vez que se usa
		 */
		public bool escribirConSaltoLinea(String valor)
		{
			try
			{
				StreamWriter sw = new StreamWriter(file, append: true);
				sw.WriteLine(valor);
				sw.Flush();
				sw.Close();
				return true;
			}catch(Exception e)
			{
				MessageBox.Show("Ha habido un error al crear el paciente");
				return false;
			}
		}

		/**
		 * Metodo para leer un archivo completo
		 */
		public void leerArchivo()
		{
			StreamReader reader = new StreamReader(file);
			String line;
			while((line = reader.ReadLine()) != null)
			{
				Console.WriteLine(line);
			}
		}

		public bool findByString(String palabra)
		{
			bool bandera = false;
			StreamReader reader = new StreamReader(file);
			String line;
			while ((line = reader.ReadLine()) != null)
			{
				if(line.Contains(palabra))
				{
					bandera = true;
				}
			}
			reader.Close();
			return bandera;
		}
	}
}
