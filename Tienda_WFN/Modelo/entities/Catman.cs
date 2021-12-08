using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
    public class Catman
    {
        long id;
        string name, category, description;
        int price, quantity;

        public long Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public string Category { get => category; set => category = value; }
        public string Description { get => description; set => description = value; }
        public int Price { get => price; set => price = value; }
        public int Quantity { get => quantity; set => quantity = value; }

        public Catman(long id, string name, string category, string description, int price, int quantity)
        {
            this.id = id;
            this.name = name;
            this.category = category;
            this.description = description;
            this.price = price;
            this.quantity = quantity;
        }

        public Catman()
        {

        }


    }


}
