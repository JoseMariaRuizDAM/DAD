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
        Controlador.Controlador c = new Controlador.Controlador();
        public Login()
        {
            InitializeComponent();
        }

        private void Login_KeyPress(object sender, KeyPressEventArgs e)
        {
            if(e.KeyChar == '\r')
            {
                validarUsuario();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            validarUsuario();
        }

        private void validarUsuario()
        {
            try
            {
                if (c.validador(long.Parse(user_box.Text), password_box.Text))
                {
                    MessageBox.Show("Bienvenido");
                }
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
