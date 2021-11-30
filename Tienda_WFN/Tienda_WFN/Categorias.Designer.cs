
namespace Tienda_WFN
{
    partial class Categorias
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Categorias));
            this.woman_btn = new System.Windows.Forms.Button();
            this.man_btn = new System.Windows.Forms.Button();
            this.kids_btn = new System.Windows.Forms.Button();
            this.news_btn = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // woman_btn
            // 
            this.woman_btn.BackColor = System.Drawing.Color.Black;
            this.woman_btn.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.woman_btn.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.woman_btn.Location = new System.Drawing.Point(30, 25);
            this.woman_btn.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.woman_btn.Name = "woman_btn";
            this.woman_btn.Size = new System.Drawing.Size(125, 54);
            this.woman_btn.TabIndex = 0;
            this.woman_btn.Text = "Woman";
            this.woman_btn.UseVisualStyleBackColor = false;
            // 
            // man_btn
            // 
            this.man_btn.BackColor = System.Drawing.Color.Black;
            this.man_btn.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.man_btn.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.man_btn.Location = new System.Drawing.Point(30, 108);
            this.man_btn.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.man_btn.Name = "man_btn";
            this.man_btn.Size = new System.Drawing.Size(125, 54);
            this.man_btn.TabIndex = 1;
            this.man_btn.Text = "Man";
            this.man_btn.UseVisualStyleBackColor = false;
            // 
            // kids_btn
            // 
            this.kids_btn.BackColor = System.Drawing.Color.Black;
            this.kids_btn.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.kids_btn.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.kids_btn.Location = new System.Drawing.Point(30, 194);
            this.kids_btn.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.kids_btn.Name = "kids_btn";
            this.kids_btn.Size = new System.Drawing.Size(125, 54);
            this.kids_btn.TabIndex = 2;
            this.kids_btn.Text = "Kids";
            this.kids_btn.UseVisualStyleBackColor = false;
            // 
            // news_btn
            // 
            this.news_btn.BackColor = System.Drawing.Color.Black;
            this.news_btn.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.news_btn.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.news_btn.Location = new System.Drawing.Point(30, 273);
            this.news_btn.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.news_btn.Name = "news_btn";
            this.news_btn.Size = new System.Drawing.Size(125, 54);
            this.news_btn.TabIndex = 3;
            this.news_btn.Text = "News";
            this.news_btn.UseVisualStyleBackColor = false;
            // 
            // Categorias
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(460, 416);
            this.Controls.Add(this.news_btn);
            this.Controls.Add(this.kids_btn);
            this.Controls.Add(this.man_btn);
            this.Controls.Add(this.woman_btn);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.SizableToolWindow;
            this.Name = "Categorias";
            this.Text = "Categorias";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button woman_btn;
        private System.Windows.Forms.Button man_btn;
        private System.Windows.Forms.Button kids_btn;
        private System.Windows.Forms.Button news_btn;
    }
}