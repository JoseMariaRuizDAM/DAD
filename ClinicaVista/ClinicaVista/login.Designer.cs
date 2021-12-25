
namespace ClinicaVista
{
    partial class login
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
			this.botonLogin = new System.Windows.Forms.Button();
			this.label1 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.textUsuario = new System.Windows.Forms.TextBox();
			this.textContraseña = new System.Windows.Forms.TextBox();
			this.SuspendLayout();
			// 
			// botonLogin
			// 
			this.botonLogin.Location = new System.Drawing.Point(168, 205);
			this.botonLogin.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
			this.botonLogin.Name = "botonLogin";
			this.botonLogin.Size = new System.Drawing.Size(150, 35);
			this.botonLogin.TabIndex = 0;
			this.botonLogin.Text = "Entrar";
			this.botonLogin.UseVisualStyleBackColor = true;
			this.botonLogin.Click += new System.EventHandler(this.botonLogin_Click);
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(76, 129);
			this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(64, 20);
			this.label1.TabIndex = 1;
			this.label1.Text = "Usuario";
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(76, 175);
			this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(92, 20);
			this.label2.TabIndex = 2;
			this.label2.Text = "Contraseña";
			// 
			// textUsuario
			// 
			this.textUsuario.Location = new System.Drawing.Point(168, 118);
			this.textUsuario.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
			this.textUsuario.Name = "textUsuario";
			this.textUsuario.Size = new System.Drawing.Size(148, 26);
			this.textUsuario.TabIndex = 3;
			// 
			// textContraseña
			// 
			this.textContraseña.Location = new System.Drawing.Point(168, 165);
			this.textContraseña.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
			this.textContraseña.Name = "textContraseña";
			this.textContraseña.PasswordChar = '*';
			this.textContraseña.Size = new System.Drawing.Size(148, 26);
			this.textContraseña.TabIndex = 4;
			// 
			// login
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(400, 311);
			this.Controls.Add(this.textContraseña);
			this.Controls.Add(this.textUsuario);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.botonLogin);
			this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
			this.Name = "login";
			this.Text = "Registro";
			this.Load += new System.EventHandler(this.Form1_Load);
			this.ResumeLayout(false);
			this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button botonLogin;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textUsuario;
        private System.Windows.Forms.TextBox textContraseña;
    }
}

