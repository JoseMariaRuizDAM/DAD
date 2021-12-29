using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{

    /**
     * Clase Category en la qu se añade toda la información de las categorias
     */
    class Category
    {
        int id_category;
        String description;

        //Constructor con los datos de la clase
        public Category(int id_category, string description)
        {
            this.id_category = id_category;
            this.description = description;
        }

        //Constructor por defecto
        public Category()
        {

        }

        //Getters y setters
        public int Id_category { get => id_category; set => id_category = value; }
        public string Description { get => description; set => description = value; }
    }
}
