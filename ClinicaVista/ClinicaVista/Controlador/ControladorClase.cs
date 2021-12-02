using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controlador
{
    public class ControladorClase
    {
        
        //ClinicaVista.AdministrativoPantalla administrativo = new ClinicaVista.AdministrativoPantalla();
        Modelo.ModeloClase m = new Modelo.ModeloClase();

        public String autenticarUsuario(String user)
        {
            switch (user)
            {
                case "director":
                    return "Bienvenido Director" +
                    "\nTe has registrado Correctamente" +
                    "\n\nLo lamentamos, esta sección esta en construcción";
                    break;
                case "administrativo":
                    
                    new ClinicaVista.AdministrativoPantalla().Visible = true;
                    return null;
                    break;
                case "administrador":
                    return "Bienvenido Administrador" +
                    "\nTe has registrado Correctamente" +
                    "\n\nLo lamentamos, esta sección esta en construcción";
                    break;
                default:
                    return null;
                    break;
            }
        }
    }
}
