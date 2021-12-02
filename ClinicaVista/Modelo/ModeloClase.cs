using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace Modelo
{
    public class ModeloClase
    {
        
        String usuario;
        String contraseña;

        public ModeloClase()
        {

        }

        public override bool Equals(object obj)
        {
            return obj is ModeloClase clase &&
                   usuario == clase.usuario &&
                   contraseña == clase.contraseña;
        }
    }
}
