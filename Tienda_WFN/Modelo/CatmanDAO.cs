using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace Modelo
{

    public class CatmanDAO
    {
        private static DBConnection dataSource;
        MySqlConnection connection = null;
        MySqlCommand mysqlCmd = null;
        MySqlDataReader mysqlReader = null;
    }
}
