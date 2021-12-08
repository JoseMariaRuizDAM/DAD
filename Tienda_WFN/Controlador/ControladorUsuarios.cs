using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Modelo;

namespace Controlador
{
    
    public class ControladorUsuarios
    {
        UserDAO userdao = new UserDAO();        

        public ControladorUsuarios()
        {

        }

        /**
         * Función que recoge un id y un password de un usuario
         * para poder validarlo con la base de datos en el userdao (modelo)
         */
        public bool validador(long id, String pass)
        {
            return userdao.checkUser(id, pass);
        }

        


    }
}
