using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controlador
{
    public class ControladorClase
    {

        Modelo.ModeloClase m = new Modelo.ModeloClase();

        public String autenticarUsuario(String user, String contraseña)
        {
            String[] lines = System.IO.File.ReadAllLines("users.txt");
            String[] nombre = new string[8];
            String[] contra = new String[8];
            String[] puesto = new String[8];
            int cont = 0;
            foreach (String line in lines)
            {
                String[] partes = line.Split(";");

                    nombre[cont] = partes[0];
                    contra[cont] = partes[1];
                    puesto[cont] = partes[2];
                    cont++;
                if (nombre[cont].Equals(user) && contra[cont].Equals(contraseña))
                {
                    switch (puesto[cont])
                    {
                        case "director":
                            return "Bienvenido Director" +
                            "\nTe has registrado Correctamente" +
                            "\n\nLo lamentamos, esta sección esta en construcción";
                            break;
                        case "administrador":
                            return "Bienvenido Administrador" +
                            "\nTe has registrado Correctamente" +
                            "\n\nLo lamentamos, esta sección esta en construcción";
                            break;
                        case "administrativo":
                            return null;
                            break;
                        case "personalsanitario":
                            return null;
                            break;
                        default:
                            return null;
                            break;
                    }
                }
            }

            
        }
    }
    
}
