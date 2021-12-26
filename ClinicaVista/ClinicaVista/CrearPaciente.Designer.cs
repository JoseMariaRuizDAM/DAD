
namespace ClinicaVista
{
	partial class CrearPaciente
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing)
		{
			if (disposing && (components != null))
			{
				components.Dispose();
			}
			base.Dispose(disposing);
		}

		#region Windows Form Designer generated code

		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.dni_label = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.label4 = new System.Windows.Forms.Label();
			this.label5 = new System.Windows.Forms.Label();
			this.label6 = new System.Windows.Forms.Label();
			this.crear_btn_crear = new System.Windows.Forms.Button();
			this.dni_crear = new System.Windows.Forms.TextBox();
			this.nombre_crear = new System.Windows.Forms.TextBox();
			this.direccion_crear = new System.Windows.Forms.TextBox();
			this.nhc_crear = new System.Windows.Forms.TextBox();
			this.apellidos_crear = new System.Windows.Forms.TextBox();
			this.poblacion_crear = new System.Windows.Forms.TextBox();
			this.SuspendLayout();
			// 
			// dni_label
			// 
			this.dni_label.AutoSize = true;
			this.dni_label.Location = new System.Drawing.Point(49, 34);
			this.dni_label.Name = "dni_label";
			this.dni_label.Size = new System.Drawing.Size(37, 20);
			this.dni_label.TabIndex = 0;
			this.dni_label.Text = "DNI";
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(49, 112);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(65, 20);
			this.label2.TabIndex = 1;
			this.label2.Text = "Nombre";
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Location = new System.Drawing.Point(49, 174);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(75, 20);
			this.label3.TabIndex = 2;
			this.label3.Text = "Dirección";
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.Location = new System.Drawing.Point(299, 34);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(43, 20);
			this.label4.TabIndex = 3;
			this.label4.Text = "NHC";
			// 
			// label5
			// 
			this.label5.AutoSize = true;
			this.label5.Location = new System.Drawing.Point(299, 112);
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(73, 20);
			this.label5.TabIndex = 4;
			this.label5.Text = "Apellidos";
			// 
			// label6
			// 
			this.label6.AutoSize = true;
			this.label6.Location = new System.Drawing.Point(507, 174);
			this.label6.Name = "label6";
			this.label6.Size = new System.Drawing.Size(78, 20);
			this.label6.TabIndex = 5;
			this.label6.Text = "Población";
			// 
			// crear_btn_crear
			// 
			this.crear_btn_crear.Location = new System.Drawing.Point(511, 55);
			this.crear_btn_crear.Name = "crear_btn_crear";
			this.crear_btn_crear.Size = new System.Drawing.Size(144, 28);
			this.crear_btn_crear.TabIndex = 6;
			this.crear_btn_crear.Text = "Crear";
			this.crear_btn_crear.UseVisualStyleBackColor = true;
			// 
			// dni_crear
			// 
			this.dni_crear.Location = new System.Drawing.Point(53, 58);
			this.dni_crear.Name = "dni_crear";
			this.dni_crear.Size = new System.Drawing.Size(164, 26);
			this.dni_crear.TabIndex = 7;
			// 
			// nombre_crear
			// 
			this.nombre_crear.Location = new System.Drawing.Point(53, 135);
			this.nombre_crear.Name = "nombre_crear";
			this.nombre_crear.Size = new System.Drawing.Size(164, 26);
			this.nombre_crear.TabIndex = 8;
			// 
			// direccion_crear
			// 
			this.direccion_crear.Location = new System.Drawing.Point(53, 206);
			this.direccion_crear.Name = "direccion_crear";
			this.direccion_crear.Size = new System.Drawing.Size(415, 26);
			this.direccion_crear.TabIndex = 9;
			// 
			// nhc_crear
			// 
			this.nhc_crear.Location = new System.Drawing.Point(303, 57);
			this.nhc_crear.Name = "nhc_crear";
			this.nhc_crear.Size = new System.Drawing.Size(165, 26);
			this.nhc_crear.TabIndex = 10;
			// 
			// apellidos_crear
			// 
			this.apellidos_crear.Location = new System.Drawing.Point(303, 135);
			this.apellidos_crear.Name = "apellidos_crear";
			this.apellidos_crear.Size = new System.Drawing.Size(352, 26);
			this.apellidos_crear.TabIndex = 11;
			// 
			// poblacion_crear
			// 
			this.poblacion_crear.Location = new System.Drawing.Point(511, 206);
			this.poblacion_crear.Name = "poblacion_crear";
			this.poblacion_crear.Size = new System.Drawing.Size(144, 26);
			this.poblacion_crear.TabIndex = 12;
			// 
			// CrearPaciente
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(720, 282);
			this.Controls.Add(this.poblacion_crear);
			this.Controls.Add(this.apellidos_crear);
			this.Controls.Add(this.nhc_crear);
			this.Controls.Add(this.direccion_crear);
			this.Controls.Add(this.nombre_crear);
			this.Controls.Add(this.dni_crear);
			this.Controls.Add(this.crear_btn_crear);
			this.Controls.Add(this.label6);
			this.Controls.Add(this.label5);
			this.Controls.Add(this.label4);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.dni_label);
			this.Name = "CrearPaciente";
			this.Text = "Crear";
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Label dni_label;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Label label5;
		private System.Windows.Forms.Label label6;
		private System.Windows.Forms.Button crear_btn_crear;
		private System.Windows.Forms.TextBox dni_crear;
		private System.Windows.Forms.TextBox nombre_crear;
		private System.Windows.Forms.TextBox direccion_crear;
		private System.Windows.Forms.TextBox nhc_crear;
		private System.Windows.Forms.TextBox apellidos_crear;
		private System.Windows.Forms.TextBox poblacion_crear;
	}
}