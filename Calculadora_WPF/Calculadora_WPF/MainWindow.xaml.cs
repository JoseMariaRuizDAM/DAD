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
                case "num1":
                    resultado.Text += "1";
                    break;
                case "num2":
                    resultado.Text += "2";
                    break;
                case "num3":
                    resultado.Text += "3";
                    break;
                case "num4":
                    resultado.Text += "4";
                    break;
                case "num5":
                    resultado.Text += "5";
                    break;
                case "num6":
                    resultado.Text += "6";
                    break;
                case "num7":
                    resultado.Text += "7";
                    break;
                case "num8":
                    resultado.Text += "8";
                    break;
                case "num9":
                    resultado.Text += "9";
                    break;
                case "sumar":
                    resultado.Text += "+";
                    break;
                case "borrarTodo":
                    resultado.Text = "0";
                    break;
                case "borraUno":
                    resultado.Text = resultado.Text.Remove(resultado.Text.Length-1);
                    break;
            }
        }
    }
}
