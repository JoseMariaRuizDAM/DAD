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
        public login()
        {

            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void botonLogin_Click(object sender, EventArgs e)
        {
            String usuario = textUsuario.Text;
            String contraseña = textContraseña.Text;
            new Controlador.ControladorClase().autenticarUsuario(usuario);

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
                if (nombre[cont].Equals(usuario) && contra[cont].Equals(contraseña))
                {
                    switch (puesto[cont])
                    {
                        case "director":
                            MessageBox.Show("Bienvenido Director" +
                    "\nTe has registrado Correctamente" +
                    "\n\nLo lamentamos, esta sección esta en construcción", "Aviso");
                            break;
                        case "administrador":
                            MessageBox.Show("Bienvenido Administrador" +
                     "\nTe has registrado Correctamente" +
                     "\n\nLo lamentamos, esta sección esta en construcción", "Aviso");
                            break;
                            break;
                        case "administrativo":
                            new AdministrativoPantalla().Visible = true;
                            break;
                        case "personalsanitario":
                            new PersonalSanitario().Visible = true;
                            
                            break;
                        default:
                            MessageBox.Show("No estas registrado en el sistema", "Aviso");
                            break;
                    }
                }
            }
            /*
            switch (usuario)
            {
                case "director":
                    MessageBox.Show("Bienvenido Director" +
                    "\nTe has registrado Correctamente" +
                    "\n\nLo lamentamos, esta sección esta en construcción", "Aviso");
                    break;
                case "administrador":
                    MessageBox.Show("Bienvenido Administrador" +
                    "\nTe has registrado Correctamente" +
                    "\n\nLo lamentamos, esta sección esta en construcción", "Aviso");
                    break;
                case "administrativo":
                    new AdministrativoPantalla().Visible = true;
                    break;
                case "personalSanitario":
                    new PersonalSanitario().Visible = true;
                    break;
                default:
                    MessageBox.Show("No estas registrado en el sistema", "Aviso");
                    break;
            }*/
            
        }
    }
}
