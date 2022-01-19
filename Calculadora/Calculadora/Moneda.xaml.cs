using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Xml;

namespace Calculadora
{
    /// <summary>
    /// Lógica de interacción para Page1.xaml
    /// </summary>
    public partial class Page1 : Page
    {
        
        public Page1()
        {
            InitializeComponent();
            //Recogo la lista con las monedas del archivo XML
            List<Moneda> monedas = leerXML();
            //añado los nombres de las monedas dentro de los comboBox
            foreach(Moneda nombres in monedas)
            {
                origen.Items.Add(nombres.Nombre);
                destino.Items.Add(nombres.Nombre);
            }
            
        }

        private void Grid_Click(object sender, RoutedEventArgs e)
        {
        }

        /**
         * Metodo que recoge las monedas del archivo XML
         * de una URL con todas las monedas y los valores
         * El metodo devuelve un @list<Moneda>
         */
        private List<Moneda> leerXML()
        {
            List<Moneda> monedas = new List<Moneda>();
            String URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
            XmlTextReader reader = new XmlTextReader(URL);
            /**
             * Comienza el bucle donde se lee la URL con los nombre de las monedas y los valores
             * recoge la información y la añade dentro de la clase moneda
             */
            while (reader.Read())
            {
                if (reader.NodeType == XmlNodeType.Element && reader.Name == "Cube")
                {
                    Moneda moneda = new Moneda();
                    moneda.Nombre = reader.GetAttribute("currency");
                    moneda.Valor = Convert.ToDouble(reader.GetAttribute("rate"), CultureInfo.InvariantCulture);
                    monedas.Add(moneda);
                    Console.WriteLine(moneda.Nombre);
                }
            }
            return monedas;
        }
    }
}
