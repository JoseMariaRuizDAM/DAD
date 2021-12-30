using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Controlador;
namespace Tienda_WFN
{
    public partial class Login : Form
    {
        Controlador.ControladorUsuarios c = new Controlador.ControladorUsuarios();
        Categorias categorias = new Categorias();
        public Login()
        {
            InitializeComponent();
        }
        /**
         * Metodo para validar el usuario cuando introduzca los datos y apriete en la tecla enter
         */
        private void Login_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == '\r')
            {
                validarUsuario();
            }
        }

        /**
         * Metodo para validar el usuario cuando introduzca los datos y apriete en el botón
         */
        private void button1_Click(object sender, EventArgs e)
        {
            validarUsuario();
        }

        /**
         * Metodo para mostrar al usuario un MessageBox según si esta dentro de la base de datos o no
         */

        private void validarUsuario()
        {
            try
            {
                /**
                 * en caso de que el usuario este dentro de la base de dato se le lanza un mensaje de bienvenida
                 * y se limpia los campos que ha completado.
                 */

                if (c.validador(long.Parse(user_box.Text), password_box.Text))
                {
                    MessageBox.Show("Bienvenido"); 
                    categorias.Show();
                    user_box.Clear();
                    password_box.Clear();
                    this.Hide();
                }
                /**
                 * En caso de que el usuario no este registrado en la base de dato se le lanza un mensaje de bienvenida
                 * y se limpia los campos que ha completado.
                 */
                else
                {
                    MessageBox.Show("No existes en la base de datos");
                    user_box.Clear();
                    password_box.Clear();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ha habido un error");
                user_box.Clear();
                password_box.Clear();
            }
        }
    }
}
