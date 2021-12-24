using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controlador
{
    public class ControladorClase
    {

        Modelo.User m = new Modelo.User();
        Modelo.dao.UserDao udao = new Modelo.dao.UserDao();
        
        /**
         * Este metodo que usa @nombre y @contraseña
         * se usa para autentificar el usuario que se ha logeado
         * en la pantalla del login.
         * Recoge los datos y según el @rol que tenga
         * devolvera el @rol
         */
        public String autenticarUsuario(String nombre, String contraseña)
        {
            
            m.Nombre = nombre;
            m.Contraseña = contraseña;
            Console.WriteLine("nombre controlador " + m.Nombre);
            String rol = udao.leerArchivo(m);
            Console.WriteLine("rol controlador " + rol);
            return rol;
        }
    }
    
}
