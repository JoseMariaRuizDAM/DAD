using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClinicaVista
{
    public partial class login : Form
    {
        AdministrativoPantalla administrativo = new AdministrativoPantalla();
        PersonalSanitario sanitario = new PersonalSanitario();
        public login()
        {

            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
        /**
         * Función que se ejecuta cuando el usuario presiona el botón de login
         */
        private void botonLogin_Click(object sender, EventArgs e)
        {
            String usuario = textUsuario.Text;
            String contraseña = textContraseña.Text;

            String autenticarRol = new Controlador.ControladorClase().autenticarUsuario(usuario, contraseña);

            getSessionRol(autenticarRol);
            
        }

        /**
         * Función que comprueba el rol del usuario
         * Mostrara un mensaje si el @rol es "director" o "administrador"
         * En caso de que el @rol sea "administrativo" o "PersonalSanitario" se mostrara el formulario correspondiente
         */
        private void getSessionRol(String rol)
        {
            switch (rol)
            {
                case "director":
                    //Muestra el mensaje siguiente en una ventana emergente
                    MessageBox.Show("Bienvenido Director" +
                    "\nTe has registrado Correctamente" +
                    "\n\nLo lamentamos, esta sección esta en construcción", "Aviso");
                    break;
                case "administrador":
                    //Muestra el mensaje siguiente en una ventana emergente
                    MessageBox.Show("Bienvenido Administrador" +
                    "\nTe has registrado Correctamente" +
                    "\n\nLo lamentamos, esta sección esta en construcción", "Aviso");
                    break;
                case "administrativo":
                    administrativo.Show(); // abre el formulario AdministrativoPantalla
                    this.Hide();
                    break;
                case "personalsanitario":
                    sanitario.Show(); // abre el formulario PersonalSanitario
                    this.Hide();
                    break;
                default:
                    MessageBox.Show("No has añadido un usuario correcto", "Aviso");
                    break;
            }
        }
    }
}
