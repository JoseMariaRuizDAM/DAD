﻿using System;
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

        public List<String> listaCategorias()
        {
            return catmanDao.listAllCategories();
        }

    }
}
