using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
    class Usuario
    {
        long id;
        String contrasena;
        String rol;
        public Usuario(long id, String contrasena, String rol)
        {
            this.id = id;
            this.contrasena = contrasena;
            this.rol = rol;
        }

        public Usuario()
        {

        }

        public long Id { get => id; set => id = value; }
        public string Contrasena { get => contrasena; set => contrasena = value; }
        public string Rol { get => rol; set => rol = value; }
    }
}
