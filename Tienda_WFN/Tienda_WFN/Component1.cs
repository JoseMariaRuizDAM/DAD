using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda_WFN
{
    public partial class Component1 : Component
    {

        //private String id;
        public Component1(String id)
        {
            id_info_component.Text = id;
            InitializeComponent();
        }

        public Component1(IContainer container)
        {
            container.Add(this);

            InitializeComponent();
        }

        private void id_label_component_Click(object sender, EventArgs e)
        {

        }
    }
}
