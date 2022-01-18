using System;
using System.Collections.Generic;
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

namespace Calculadora_WPF
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        double aux;
        public MainWindow()
        {
            InitializeComponent();
            historial.Content = 0;
            resultado.Text = "0";
        }

        private void Grid_Click(object sender, RoutedEventArgs e)
        {
            FrameworkElement fe = e.Source as FrameworkElement;

            switch (fe.Name)
            {
                //botones numeros
                case "num0":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "0";
                    }
                    else
                    {
                        resultado.Text += "0";
                    }
                    break;
                case "num1":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "1";
                    }
                    else
                    {
                        resultado.Text += "1";
                    }
                    break;
                case "num2":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "2";
                    }
                    else
                    {
                        resultado.Text += "2";
                    }
                    break;
                case "num3":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "3";
                    }
                    else
                    {
                        resultado.Text += "3";
                    }
                    break;
                case "num4":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "4";
                    }
                    else
                    {
                        resultado.Text += "4";
                    }
                    break;
                case "num5":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "5";
                    }
                    else
                    {
                        resultado.Text += "5";
                    }
                    break;
                case "num6":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "6";
                    }
                    else
                    {
                        resultado.Text += "6";
                    }
                    break;
                case "num7":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "7";
                    }
                    else
                    {
                        resultado.Text += "7";
                    }
                    break;
                case "num8":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "8";
                    }
                    else
                    {
                        resultado.Text += "8";
                    }
                    break;
                case "num9":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "9";
                    }
                    else
                    {
                        resultado.Text += "9";
                    }
                    break;

                //boton de coma
                case "coma":
                    if (resultado.Text.Equals("0") || aux == 0)
                    {
                        resultado.Text = "0,";
                    }
                    else if (resultado.Text.Equals(""))
                    {
                        resultado.Text = "0,";
                    }
                    else if (resultado.Text.Contains(","))
                    {
                        
                    }
                    else
                    {
                        resultado.Text += ",";
                    }
                    break;

                //botones operadores
                case "sumar":
                    if (historial.Content.Equals(0))
                    {
                        aux = double.Parse(resultado.Text);
                        historial.Content = resultado.Text;
                        resultado.Text = "0";
                    }
                    else if (historial.Content.ToString().Contains("x"))
                    {
                        aux *= double.Parse(resultado.Text);
                        historial.Content = aux + "+";
                        resultado.Text = "0";
                    }
                    else
                    {
                        aux += double.Parse(resultado.Text);
                        historial.Content = aux + "+";
                        resultado.Text = "0";
                    }
                    break;

                case "restar":
                    if (historial.Content.Equals(0))
                    {
                        aux = double.Parse(resultado.Text);
                        historial.Content = resultado.Text + "-";
                        resultado.Text = "0";
                    }
                    else if (historial.Content.ToString().Contains("x")) 
                    {
                        aux *= double.Parse(resultado.Text);
                        historial.Content = aux + "-";
                        resultado.Text = "0";
                    }
                    else
                    {
                        aux -= double.Parse(resultado.Text);
                        historial.Content = aux + "-";
                        resultado.Text = "0";
                    }
                    break;


                case "multi":
                    if (historial.Content.Equals(0))
                    {
                        aux = double.Parse(resultado.Text);
                        historial.Content = resultado.Text + "x";
                        resultado.Text = "0";
                    }
                    else
                    {
                        aux *= double.Parse(resultado.Text);
                        historial.Content = aux + "x";
                        resultado.Text = "0";
                    }
                    break;

                case "division":
                    if (historial.Content.Equals(0))
                    {
                        aux = double.Parse(resultado.Text);
                        historial.Content = resultado.Text + "/";
                        resultado.Text = "0";
                    }
                    else
                    {
                        aux /= double.Parse(resultado.Text);
                        historial.Content = aux + "/";
                        resultado.Text = "0";
                    }
                    break;

                //botones de borrado
                case "borrarTodo":
                    resultado.Text = "0";
                    historial.Content = 0;
                    aux = 0;
                    break;
                case "borrarUno":                    
                    if(resultado.Text.Length > 0)
                    {
                        resultado.Text = resultado.Text.Remove(resultado.Text.Length - 1, 1);
                    }
                    break;

                //boton de calculo
                case "calcular":
                    if (!resultado.Text.Equals("0"))
                    {
                        aux += double.Parse(resultado.Text);
                        resultado.Text = aux.ToString();
                        aux = 0;
                    }
                    else
                    {
                        resultado.Text = aux.ToString();
                        aux = 0;
                    }
                    break;
            }
        }

        private void botonIgual()
        {
            
        }
    }
}
