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
        double aux;
        List<Moneda> monedas = new List<Moneda>();
        String monedaOrigen;
        String monedaDestino;
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
            FrameworkElement fe = e.Source as FrameworkElement;

            switch (fe.Name)
            {
                //botones numeros
                case "num0":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "0";
                    }
                    else
                    {
                        resultOri.Text += "0";
                    }
                    break;
                case "num1":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "1";
                    }
                    else
                    {
                        resultOri.Text += "1";
                    }
                    break;
                case "num2":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "2";
                    }
                    else
                    {
                        resultOri.Text += "2";
                    }
                    break;
                case "num3":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "3";
                    }
                    else
                    {
                        resultOri.Text += "3";
                    }
                    break;
                case "num4":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "4";
                    }
                    else
                    {
                        resultOri.Text += "4";
                    }
                    break;
                case "num5":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "5";
                    }
                    else
                    {
                        resultOri.Text += "5";
                    }
                    break;
                case "num6":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "6";
                    }
                    else
                    {
                        resultOri.Text += "6";
                    }
                    break;
                case "num7":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "7";
                    }
                    else
                    {
                        resultOri.Text += "7";
                    }
                    break;
                case "num8":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "8";
                    }
                    else
                    {
                        resultOri.Text += "8";
                    }
                    break;
                case "num9":
                    if (resultOri.Text.Equals("0"))
                    {
                        resultOri.Text = "9";
                    }
                    else
                    {
                        resultOri.Text += "9";
                    }
                    break;

                //boton de coma
                case "coma":
                    if (resultOri.Text.Equals("0") || aux == 0)
                    {
                        resultOri.Text = "0,";
                    }
                    else if (resultOri.Text.Equals(""))
                    {
                        resultOri.Text = "0,";
                    }
                    else if (resultOri.Text.Contains(","))
                    {

                    }
                    else
                    {
                        resultOri.Text += ",";
                    }
                    break;

                //botones de borrado
                case "borrarTodo":
                    resultOri.Text = "0";
                    resultDest.Text = "0";
                    aux = 0;
                    break;
                case "borrarUno":
                    if (resultOri.Text.Length > 0)
                    {
                        resultOri.Text = resultOri.Text.Remove(resultOri.Text.Length - 1, 1);
                    }
                    break;

                case "origen":
                    Console.WriteLine("prueba2");
                    //calculoRate();
                    break;
            }
        }

        /**
         * Metodo que recoge las monedas del archivo XML
         * de una URL con todas las monedas y los valores
         * El metodo devuelve un @list<Moneda>
         */
        public List<Moneda> leerXML()
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
                }
            }
            return monedas;
        }

        public void calculoRate()
        {
            double cambio = 0;
            
            //Corregir esta parte en la que tengo que añadir la monedaOrigen si esta vacia
            //Si esta vacio el item no se añade.
            if (!monedaOrigen.Equals(""))
            {
                monedaOrigen = origen.SelectedItem.ToString();
                monedaDestino = destino.SelectedItem.ToString();
            }


            //añado los nombres de las monedas dentro de los comboBox
            foreach (Moneda nombres in monedas)
            { 
                Console.WriteLine(nombres.Nombre + 
                    " valor: " + nombres.Valor);
            }
            //return cambio;
        }
    }
}
