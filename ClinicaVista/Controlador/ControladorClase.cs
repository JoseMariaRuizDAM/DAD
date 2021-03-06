using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Controlador
{
    public class ControladorClase
    {

        Modelo.User m = new Modelo.User();
        Modelo.dao.UserDao udao = new Modelo.dao.UserDao();
        Modelo.dao.patientDao pdao = new Modelo.dao.patientDao();
        Modelo.Utilities.FileManager fileManager = new Modelo.Utilities.FileManager();
        
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
            String rol = udao.leerArchivo(m);
            return rol;
        }

        /**
         * Metodo para registrar un paciente con los datos que se le pasan desde la vista
         * Se pasan los datos al dao de paciente
         */
        public bool registrarPaciente(String DNI, String nombre, String apellidos, String direccion, String poblacion, String nhc)
        {
            bool creado = false;
            try{
                creado = pdao.crearPaciente(DNI, nombre, apellidos, direccion, poblacion, nhc);
            }catch(Exception e)
            {
                MessageBox.Show("Error al crear el paciente");
            }
            return creado;
        }

        /*
         * Metodo para comprobar que el DNI que introduce el usuario
         * es correcto, al ser la letra correcta y el tamaño también.
         * También se comprueba si existe ya en el archivo o no.
         */
        public bool comprobarDNI(String dni)
        {
            bool correcto = false;
            try
            {

                char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
                String numDNI = dni.Substring(0, 8);
                String letra = dni.Substring(8).ToUpper();
                int resto = Int32.Parse(numDNI) % 23;
                String letraResto = letras[resto].ToString();
                if (letraResto.Equals(letra))
                {
                    correcto = true;
                }
            }
            catch (Exception e)
            {
                MessageBox.Show("Ha habido un error en el DNI: " +
                    "\nDebe de tener 8 números y una letra");
                correcto = false;
            }

            return correcto;
        }
    }
}
    

