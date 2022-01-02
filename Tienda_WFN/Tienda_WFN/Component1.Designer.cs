
namespace Tienda_WFN
{
    partial class Component1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de componentes

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.id_label_component = new System.Windows.Forms.Label();
            this.id_info_component = new System.Windows.Forms.Label();
            this.name_component = new System.Windows.Forms.Label();
            // 
            // id_label_component
            // 
            this.id_label_component.AutoSize = true;
            this.id_label_component.Location = new System.Drawing.Point(0, 0);
            this.id_label_component.Name = "id_label_component";
            this.id_label_component.Size = new System.Drawing.Size(100, 23);
            this.id_label_component.TabIndex = 0;
            this.id_label_component.Text = "ID";
            this.id_label_component.Click += new System.EventHandler(this.id_label_component_Click);
            // 
            // id_info_component
            // 
            this.id_info_component.AutoSize = true;
            this.id_info_component.Location = new System.Drawing.Point(0, 0);
            this.id_info_component.Name = "id_info_component";
            this.id_info_component.Size = new System.Drawing.Size(100, 23);
            this.id_info_component.TabIndex = 0;
            this.id_info_component.Text = "label2";
            // 
            // name_component
            // 
            this.name_component.AutoSize = true;
            this.name_component.Location = new System.Drawing.Point(0, 0);
            this.name_component.Name = "name_component";
            this.name_component.Size = new System.Drawing.Size(100, 23);
            this.name_component.TabIndex = 0;
            this.name_component.Text = "Name";

        }

        #endregion

        private System.Windows.Forms.Label id_label_component;
        private System.Windows.Forms.Label id_info_component;
        private System.Windows.Forms.Label name_component;
    }
}
