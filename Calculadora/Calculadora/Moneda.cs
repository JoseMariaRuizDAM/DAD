using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculadora
{
    public class Moneda
    {
        String nombre;
        double valor;

        /**
         * Constructor por defecto
         */
        public Moneda()
        {
        }

        /**
         * Constructor que obtiene el @nombre de la moneda
         * y el @valor de la moneda
         */
        public Moneda(String nombre, double valor)
        {
            this.nombre = nombre;
            this.valor = valor;
        }

        //Getters y setters
        public string Nombre { get => nombre; set => nombre = value; }
        public double Valor { get => valor; set => valor = value; }
    }
}
