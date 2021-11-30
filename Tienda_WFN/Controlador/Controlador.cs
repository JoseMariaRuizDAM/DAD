using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Modelo;

namespace Controlador
{
    public class Controlador
    {
        UserDAO udao = new UserDAO();

        public bool validador(long id, String pass)
        {
            return udao.checkUser(id, pass);
        }
    }
}
