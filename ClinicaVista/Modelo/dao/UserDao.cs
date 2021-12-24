using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Modelo.dao
{
	public class UserDao
	{
		User user;
		String archivo = "users.txt"; //nombre del archivo donde se recoge la información de los usuarios
		int numUsuarios = 8; //número de usuarios que hay dentro del archivo users.txt
		
        /**
		 * Constructor por defecto
		 */
		public UserDao(){}

		// Metodo para leer el archivo users.txt y devolver el rol del nombre
		public String leerArchivo(User usuario)
		{
            user = new User(usuario.Nombre, usuario.Contraseña);
            String rol = "";
            try
            {
                String[] lines = System.IO.File.ReadAllLines(archivo); // Se leen todas la lineas del documento
			    String[] nombre = new String[numUsuarios];
			    String[] contra = new String[numUsuarios];
			    String[] puesto = new String[numUsuarios];
                int cont = 0;
                foreach (String line in lines)
                {
                        String[] partes = line.Split(';'); //se divide cada linea con un split

                        nombre[cont] = partes[0]; // nombre del nombre en el archivo
                        contra[cont] = partes[1]; // contraseña del nombre en el archivo
                        puesto[cont] = partes[2]; // rol del nombre en el archivo
                    Console.WriteLine("nombre dao " + cont + " " + nombre[cont] + "\nNombre usuario"+ user.Nombre  );
                    Console.WriteLine("contraseña dao " + cont + " " + contra[cont] + "\nContra usuario" + user.Contraseña);
                    String recogerNombre = nombre[cont];
                    String recogerContra = contra[cont];
                    //Se comprueba si es igual el nombre que se le ha pasado a los datos que estan dentro del archivo
                    if (recogerNombre.Equals(user.Nombre) && recogerContra.Equals(user.Contraseña))
                        {
                            return rol = puesto[cont];
                        }
                        else
                        {
                            return rol = "Usuario no existe";
                        }
                        cont++; // se usa el contador para saber que nombre es y se suma uno a cada vuelta del foreach

                }
            }
            catch(Exception e){
                String error = e.Message;
                MessageBox.Show("Ha habido un error: " + error, "Error");
                rol = null;
            }
        }
        public String checkUser(User user)
		{
			return user.Nombre;
		}
	}
}
