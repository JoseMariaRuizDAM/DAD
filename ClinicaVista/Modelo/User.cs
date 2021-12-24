using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
namespace Modelo
{
    public class User
    {
        
        String nombre;
        String contraseña;

        /**
         * Constructor por defecto vacio
         */
        public User()
        {

        }

        /**
         * Constructor en el que se reciben el nombre
         * y la contraseña
         */
        public User(String nombre, String contraseña)
        {
            this.nombre = nombre;
            this.contraseña = contraseña;
        }

        //Getters y setters
		public string Nombre { get => nombre; set => nombre = value; }
		public string Contraseña { get => contraseña; set => contraseña = value; }

		public override bool Equals(object obj)
        {
            return obj is User clase &&
                   nombre == clase.nombre &&
                   contraseña == clase.contraseña;
        }
    }
}
