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
         * Este metodo que usa @user y @contraseña
         * se usa para autentificar el usuario que se ha logeado
         * en la pantalla del login.
         * Recoge los datos y según el rol que tenga
         * devolvera un mensaje o hara que se abra una interfaz
         * dependiendo del rol del usuario
         */
        public String autenticarUsuario(String nombre, String contraseña)
        {
            m.Nombre = nombre;
            m.Contraseña = contraseña;

            String rol = udao.leerArchivo(m);

            switch (nombre)
            {
                case "director":
                    //Devuelve el mensaje siguiente para que lo muestre en el login
                    return "Bienvenido Director" +
                    "\nTe has registrado Correctamente" +
                    "\n\nLo lamentamos, esta sección esta en construcción";
                    break;
                case "administrador":
                    //Devuelve el mensaje siguiente para que lo muestre en el login
                    return "Bienvenido Administrador" +
                    "\nTe has registrado Correctamente" +
                    "\n\nLo lamentamos, esta sección esta en construcción";
                    break;
                case "administrativo":
                    return user; // devuelve el usuario al login
                    break;
                case "personalsanitario":
                    return user; // devuelve el usuario al login
                    break;
                default:
                    return "No has añadido un usuario correcto";
                    break;
            }
        }
    }
    
}
