using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Modelo;

namespace Controlador
{
    public class ControladorCatman
    {
        CatmanDAO catmanDao = new CatmanDAO();

        //Constructor por defecto
        public ControladorCatman()
        {

        }

        /**
         * Función que devuelve un DataTable para poder mostrarlo en la vista
         * Los datos serán recogidos en la base de datos y se usan los de la tabla catman
         */
        public DataTable tablaCatman()
        {
            return catmanDao.tablaGrid();
        }

        /**
         * Metodo que se utiliza para filtrar por la categoria
         * que se ha seleccionado en el listview
         * Se hace una consulta a la base de datos con @categoria
         * y devuelve una nueva datatable con el filtro
         */
        public DataTable FiltrarCategoria(String categoria)
        {
            return catmanDao.filtrarCategoria(categoria);
        }

        /**
         * Metodo que devuelve una DataTable actualizada
         * Recoge el @id del producto y @quantity (cantidad)
         */
        public DataTable updateQuantity(String id, int quantity)
        {
            return catmanDao.updateQuantity(id, quantity);
        }

        public bool addBasket(String id, String name, double total)
        {
            Console.WriteLine("Entro en controladorCatman addbasket total " + total);
            return catmanDao.addBasket(id, name, total);
        }
        /**
         * Función que devuelve un DataTable para poder mostrarlo en la vista
         * Los datos serán recogidos en la base de datos y se usan los de la tabla catman
         */
        public List<String> listaCategorias()
        {
            return catmanDao.listAllCategories();
        }

    }
}
