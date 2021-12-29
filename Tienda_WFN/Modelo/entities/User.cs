using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{

    /**
     * Clase del usuario en el que se encuentra
     * la información de los usuarios
     * el @id, @contrasena y @rol
     */
    public class User
    {
        long id;
        String contrasena;
        String rol;

        //Constructor con todos los datos del usuario
        public User(long id, String contrasena, String rol)
        {
            this.id = id;
            this.contrasena = contrasena;
            this.rol = rol;
        }

        //Constructor por defecto
        public User()
        {

        }

        //Getters y setters
        public long Id { get => id; set => id = value; }
        public string Contrasena { get => contrasena; set => contrasena = value; }
        public string Rol { get => rol; set => rol = value; }
    }
}
