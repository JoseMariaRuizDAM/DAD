using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Modelo;

namespace Controlador
{
    public class ControladorCategorias
    {

        CategoryDAO categoryDao = new CategoryDAO();

        public ControladorCategorias()
        {
            
        }
        public List<String> recogerCategorias()
        {
            return categoryDao.findAll();
        }
    }
}
